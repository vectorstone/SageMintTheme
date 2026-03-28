plugins {
    id("org.jetbrains.intellij.platform") version "2.13.1"
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdea(providers.gradleProperty("platformVersion"))
        pluginVerifier()
        zipSigner()
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginConfiguration {
        name = providers.gradleProperty("pluginName")
        version = providers.gradleProperty("pluginVersion")

        description = """
            A static IntelliJ IDEA theme plugin for the 2025.3 Islands UI with mint light
            and night variants, built around the Sage Mint palette.
        """.trimIndent()

        changeNotes = """
            <ul>
              <li>Added the new <b>Sage Mint Night</b> dark theme for the 2025.3 Islands UI.</li>
              <li>Added a matching <b>Sage Mint Night</b> editor color scheme.</li>
              <li>Kept the original mint theme as the light variant for a complete light/night pair.</li>
            </ul>
        """.trimIndent()

        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        channels = providers.gradleProperty("pluginVersion").map { pluginVersion ->
            val suffix = pluginVersion.substringAfter('-', "")
            listOf(suffix.substringBefore('.').ifEmpty { "default" })
        }
    }
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    publishPlugin {
        dependsOn(signPlugin)
    }
}
