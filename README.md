# selenium-java-pom-swagLabs
Page Object Model on SwagLabs

# Selenium Tests for https://www.saucedemo.com/
This project contains a set of Selenium tests using the Page Object Model (POM) approach to test the following scenarios on the https://www.saucedemo.com/ website:

Login with valid credentials (standard_user and secret_sauce) and assert that the login is successful.
Logout and assert that the login page is displayed.
Login with invalid credentials and assert that the correct error message is displayed.
# Getting Started
# Prerequisites
Before running the tests, you need to have the following software installed on your machine:

# [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
Maven
ChromeDriver
# Installation
Clone the repository to your local machine.
In the project root directory, run mvn clean install to download the dependencies and build the project.
# Running the tests
To run the tests, execute the following command in the project root directory:

mvn test

# Test Structure
The tests are written in Java using the TestNG testing framework and the Selenium WebDriver API. The tests use the Page Object Model (POM) approach to separate the page logic from the test logic.

# Test Classes
The tests are contained in the SwagLabsTest class, which contains three test methods for the scenarios described above. Each test method instantiates a LoginPage object and calls methods on that object to perform the test.

# Page Objects
The LoginPage class represents the Login page and contains methods for interacting with the page elements. The LoginPage class uses the Selenium WebDriver and By classes to locate and interact with the page elements.

# Authors
Kodjo Semeglo
# License
This project is licensed under the MIT License - see the LICENSE file for details.
