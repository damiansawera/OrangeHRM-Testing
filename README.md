# 🚀 Selenium Test Automation Project for OrangeHRM

This project is a comprehensive Selenium-based test automation framework designed for testing the popular Human Resource Management system, OrangeHRM. It leverages the power of Page Object Model (POM) to create scalable and maintainable test scripts.

### Key Features:

- Utilizes **Selenium WebDriver** for interacting with web elements and performing actions on the web application.
- Implements **Page Object Model** design pattern for better code organization and reusability.
- Supports cross-browser testing by utilizing **Selenium Grid with Docker** for parallel test execution on Chrome, Edge, and Firefox browsers.
- Allows users to easily switch between running tests on a local environment or using the Selenium Grid with Docker, providing optimal flexibility for various testing scenarios.
- Uses the **allure-reports** library for generating interactive and informative test reports, helping you visualize test results effectively.
- **Jenkinsfile** is included for setting up automated **CI/CD pipelines effortlessly**, with built-in support for dynamic configuration changes based on build parameters.
- The configuration.properties file enables users to control test behavior through simple configuration options.
- **Faker** library integration facilitates the generation of realistic test data for various scenarios.
- [WORK IN PROGRESS] **Cucumber** - Empowers behavior-driven development (BDD) by enabling Gherkin syntax for writing human-readable test scenarios and automatically linking them to executable step definitions in Java.

## Pre-requisites
Before running this Selenium-based testing project, ensure that you have the following pre-requisites and dependencies installed:

- **Java Development Kit (JDK)**: Ensure that you have Java JDK 8 or higher installed on your machine. You can download it from the official Oracle website or use OpenJDK.

- **Maven**: Maven is a build automation tool used in this project. Install Maven by following the official Apache Maven installation guide for your operating system.

- **Docker**: Docker is a platform that allows you to build, ship, and run applications in containers. To install Docker, visit the official Docker website (https://www.docker.com/get-started) and follow the installation instructions for your operating system.

- **Jenkins**: Jenkins is an open-source automation server for continuous integration and continuous delivery (CI/CD); to install, visit the official website and download the appropriate installer for your OS.

- **Integrated Development Environment**: Choose an IDE of your preference for Java development, preferably IntelliJ IDEA or Eclipse.

- **Dependencies**: The project relies on various dependencies managed by Maven. The pom.xml file in the project contains the necessary dependency configurations. Ensure that you have a reliable internet connection during the initial project setup to allow Maven to download the required dependencies.

## Execution
1. Open your preferred IDE (IntelliJ IDEA, Eclipse)
2. Import the project as a Maven project by selecting the project's root directory
3. Go to *src/test/java/config/configuration.properties* file and set *isRemote* to **true** if you want to use docker (make sure Docker Desktop is running) and run tests on multiple browsers with Selenium Grid or set *isRemote* to **false** if you want to run tests locally.
4. Run the tests either by right-clicking on the test class or specific test case(s) and selecting "Run" or by running **testng.xml** file.
5. You can also run the project by typing **mvn clean test** or **mvn clean install** in the terminal. Make sure you are within the project root directory.

## Jenkins Integration
### Pre-requisites
- Have Jenkins installed on your machine
- Necessary plugins installed
- Jenkins Tools configured

### Create a New Jenkins Pipeline Job:

1. From the Jenkins dashboard, click on "New Item" to create a new job
2. Provide a name for the job and select the **"Pipeline"** option
3. in General section check **This project is parametrized** and set text parameter:

   **Name**: isRemote

   **Default value**: false
5. In Pipeline section set *Definition* to **Pipeline Script From SCM**
6. Set SCM to **Git** and Repository URL to https://github.com/damiansawera/OrangeHRM-Testing.git
7. Set *Branches to build* to ***/main**
8. *Script path* set to **Jenkinsfile**

Now you can run the pipeline by clicking **Build with parameters** and set the parameter *isRemote* to **true** if you want to use docker or set *isRemote* to **false** if you want to run tests locally.

If you are running your tests remotely with docker, make sure your Docker Desktop is turned on.

You can see Allure Report as a build artifact after the pipeline finishes. (Make sure you have Allure plugin installed in Jenkins). 


With this test automation framework, you can easily create and execute end-to-end tests for OrangeHRM. Happy testing! 😊
