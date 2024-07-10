# Project Architecture

This document outlines the architecture of the Gradle-based Java/Kotlin project, focusing on its modular design, dependencies, and build configuration.

## Overview

The project is structured into multiple modules, each serving a distinct role within the application. It leverages Gradle as the build automation tool, facilitating dependency management, module compilation, and packaging.

## Modules

The project is divided into the following main modules:

- `context1`: Contains business logic and domain models relevant to the first context of the application.
- `context2`: Encapsulates the business logic and domain models for the second context of the application.
- `app`: The entry point of the application, integrating modules `context1` and `context2`.

### context1 and context2 Modules

Both `context1` and `context2` are designed following the hexagonal architecture principles, separating the core logic from external concerns like UI, database access, and external integrations.

- **Ports**: Defined under `ports.inbound` and `ports.outbound` packages, these interfaces abstract the core domain logic from external interactions.
- **Adapters**: Implementations of the ports, adapting the core logic to specific external frameworks or technologies.

### app Module

The `app` module orchestrates the application flow, wiring together components from `context1` and `context2` modules and providing the main runtime environment.

## Dependencies

Capabilities from `context1` and `context2` modules are required explicitly to ensure modularity and encapsulate specific functionalities.

## Build Configuration

The project employs a Kotlin-based Gradle configuration (`build.gradle.kts`), specifying plugins, dependencies, and project metadata:

- **Plugins**: Quarkus conventions are applied for streamlined configuration and build optimizations.
- **Dependencies**: Dependencies are declared for Quarkus extensions and inter-module dependencies, ensuring the correct versions and configurations are applied.
- **Capabilities**: The `requireCapability` function is used to explicitly declare dependencies on capabilities provided by `context1` and `context2` modules, promoting a modular and decoupled architecture.

## Building the Project

To build the project, navigate to the project root directory and execute the following command:

```shell
./gradlew build
```

This command compiles the modules, runs tests, and packages the application.

## Running the Application

After building, the application can be run using:

```shell
cd app/build/distributions
unzip app-*.zip
app-*/bin/app
```
