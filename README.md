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

## Development

This project uses the IntelliJ Platform Gradle Plugin.

```bash
export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.15-amzn"
./gradlew runIde
./gradlew buildPlugin
```

The packaged plugin ZIP will be generated under `build/distributions/`.

## Project Structure

- `src/main/resources/META-INF/plugin.xml`: plugin descriptor and static theme registration
- `src/main/resources/themes/sage-mint.theme.json`: Islands Light theme definition
- `src/main/resources/colorSchemes/SageMint.xml`: matching editor color scheme

## Marketplace Notes

- Plugin ID: `com.wangxiaoguang.sageminttheme`
- Since build: `253`
- Repository URL is currently a placeholder and should be updated before publishing
