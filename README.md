# Chorus Playground
This project is built using the following set of tools:
- Intellij IDE
- Java 8
- [Gradle](https://gradle.org/install/)
- [Microsoft Playwright 1.10.0](https://github.com/microsoft/playwright-java)
- TestNG

The platform used is MacOS 11.2.1 Big Sur

The given task was to use automation to find what services are available to me on the 
Chorus web site so I can decide on the service I want to order

## Assumed workflow
    - Navigate to Chorus service map
    - Select Broadband checker
    - Input address to check services against
    - Select address from results list
    - Get available services text

## Run in CLI
** system prequisites: Java 1.8, Gradle 5.1.1 +

- clone project to local
- navigate to local repository root directory
- open directory in command line / cmd prompt
> gradle clean build --info
- or using the wrapper
> ./gradlew clean build test --info
  