# Sage Mint Theme

Sage Mint Theme is a static IntelliJ Platform theme plugin for the 2025.3 Islands UI. It now
ships with both a light mint variant and a dark `Sage Mint Night` variant built around the same
calm green visual direction.

## Preview

- Base themes: `Sage Mint` and `Sage Mint Night`
- UI target: IntelliJ IDEA `2025.3` Islands UI
- Delivery target: local installable plugin package and JetBrains Marketplace-ready metadata

## Features

- A mint light theme for the new Islands UI
- A matching `Sage Mint Night` dark theme
- Separate bundled editor schemes for both light and night variants
- Static theme behavior with no runtime configuration logic

## Marketplace Description

Sage Mint Theme is a static theme plugin for IntelliJ IDEA 2025.3 and newer, designed for the
new Islands UI.

Version 0.3.0 introduces `Sage Mint Night`, a dark companion to the original mint light theme.
Together they provide a consistent green visual identity across the IDE shell, tool windows,
tabs, dialogs, popups, and editor surfaces.

The plugin keeps the experience simple: install it, choose either `Sage Mint` or `Sage Mint Night`,
and use the matching bundled editor color scheme for a coherent workspace.

Highlights:

- Built for IntelliJ IDEA 2025.3 Islands UI
- Includes both light and dark mint theme variants
- Matching bundled editor color schemes
- Static behavior with no runtime settings or mode switching logic

## Development

This project uses the IntelliJ Platform Gradle Plugin and requires Java 21.

```bash
export JAVA_HOME="$(cd /opt/homebrew/opt/sdkman-cli/libexec/candidates/java/current && pwd -P)"
export PATH="$JAVA_HOME/bin:$PATH"

./gradlew runIde
./gradlew buildPlugin
```

The packaged plugin ZIP will be generated under `build/distributions/`.

## Publishing

Update `pluginVersion` in `gradle.properties` before each release, then prepare the required
JetBrains Marketplace environment variables:

```bash
export JAVA_HOME="$(cd /opt/homebrew/opt/sdkman-cli/libexec/candidates/java/current && pwd -P)"
export PATH="$JAVA_HOME/bin:$PATH"

export CERTIFICATE_CHAIN="$(cat /absolute/path/to/chain.crt)"
export PRIVATE_KEY="$(cat /absolute/path/to/private.pem)"
export PRIVATE_KEY_PASSWORD="your-private-key-password"
export PUBLISH_TOKEN="your-marketplace-token"
```

Build, sign, verify, and publish with:

```bash
./gradlew buildPlugin
./gradlew signPlugin
./gradlew verifyPlugin
./gradlew publishPlugin
```

Release checklist:

```bash
# 1. bump pluginVersion in gradle.properties
# 2. update changelog and marketplace copy

# 3. build and sign
./gradlew buildPlugin
./gradlew signPlugin

# 4. verify compatibility
./gradlew verifyPlugin

# 5. publish to JetBrains Marketplace
./gradlew publishPlugin
```

## Project Structure

- `src/main/resources/META-INF/plugin.xml`: plugin descriptor and static theme registration
- `src/main/resources/themes/sage-mint.theme.json`: Islands Light theme definition
- `src/main/resources/colorSchemes/SageMint.xml`: matching editor color scheme

## Marketplace Notes

- Plugin ID: `com.wangxiaoguang.sageminttheme`
- Since build: `253`
- Repository URL: `https://github.com/vectorstone/SageMintTheme`
- Signing uses `CERTIFICATE_CHAIN`, `PRIVATE_KEY`, and `PRIVATE_KEY_PASSWORD`
- Publishing uses `PUBLISH_TOKEN`
