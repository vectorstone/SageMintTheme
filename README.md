# Sage Mint Theme

Sage Mint Theme is a static IntelliJ Platform theme plugin for the 2025.3 Islands UI. It uses
`#BFE2BE` as the fixed background anchor color across the IDE shell and editor surfaces.

## Preview

- Base theme: `Islands Light`
- Fixed palette: `#BFE2BE`
- Delivery target: local installable plugin package and JetBrains Marketplace-ready metadata

## Features

- Islands-aware backgrounds for the main IDE shell, tool windows, tabs, dialogs, and inputs
- Matching static editor scheme so the editor canvas stays aligned with the mint UI palette
- No runtime configuration logic, which keeps the theme behavior predictable

## Marketplace Description

Sage Mint Theme is a clean static theme for IntelliJ IDEA 2025.3 and newer. It brings the new
Islands UI into a soft mint palette centered on `#BFE2BE`, while keeping editor surfaces,
tool windows, tabs, menus, and popup panels visually consistent.

The goal is simple: a calm green workspace without dynamic settings, without mode switches, and
without visual noise. Install the theme, select `Sage Mint Theme`, and the IDE adopts a unified
mint color line with a matching `Sage Mint` editor color scheme.

Highlights:

- Built for the 2025.3 Islands UI
- Unified mint palette anchored by `#BFE2BE`
- Matching static editor scheme
- Simple static theme behavior with no runtime configuration

## Development

This project uses the IntelliJ Platform Gradle Plugin.

```bash
export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.15-amzn"
./gradlew runIde
./gradlew buildPlugin
```

The packaged plugin ZIP will be generated under `build/distributions/`.

## Publishing

Update `pluginVersion` in `gradle.properties` before each release, then prepare the required
JetBrains Marketplace environment variables:

```bash
export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.15-amzn"
export CERTIFICATE_CHAIN="$(cat path/to/chain.crt)"
export PRIVATE_KEY="$(cat path/to/private.pem)"
export PRIVATE_KEY_PASSWORD="your-private-key-password"
export PUBLISH_TOKEN="your-marketplace-token"
```

Build, sign, and publish with:

```bash
./gradlew buildPlugin
./gradlew signPlugin
./gradlew publishPlugin
```

For a first Marketplace release, upload the signed ZIP manually in the Marketplace web UI first.
After the plugin entry exists, `publishPlugin` can be used for subsequent releases.

Release checklist:

```bash
# 1. bump pluginVersion in gradle.properties
# 2. rebuild
./gradlew buildPlugin

# 3. sign locally
./gradlew signPlugin

# 4. first release: upload signed ZIP in Marketplace web UI
# 5. later releases: publish with Gradle
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
