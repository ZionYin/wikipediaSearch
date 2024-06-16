

# Automated Tests for Wikipedia advanced search


## About The Project

This suite of automated tests can verify the functionality of the wikipedia advanced search, including basic search functionality, search suggestions and pagination.


### Built With

#### Frontend:

- [Selenium](https://www.selenium.dev/): Headless web browser in support of test automation
- [Cucumber](https://cucumber.io/): BDD tool with Gherkin language for defining executable specifications in human readable format.
- [JUnit](https://junit.org/junit5/): Java testing framework that provides annotations and assertions.


## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/ZionYin/wikipediaSearch.git
   cd wikipediaSearch
   ```
2. Import project into IDE
   - Import the peoject as Maven project
3. Install dependencies
   ```sh
   mvn install
   ```


## Usage

### Run Smoke Tests
1. Open SmokeRunner.java located in src/test/java/com/wikipedia/runners/

2. Right-click on SmokeRunner class and select Run as JUnit Test

### Run Regression Tests
1. Open RegressionRunner.java located in src/test/java/com/wikipedia/runners/

2. Right-click on RegressionRunner class and select Run as JUnit Test

## Project Structure and Design Decisions
Page Object Model (POM)

- Structure: Each web page or component of the application is represented by a Page Object class (e.g., WikipediaSearchPage).
- Benefits: Encapsulates UI interaction logic within reusable methods, enhancing maintainability and reducing code duplication.

Page Factory

- Usage: Page Factory is used to initialize Page Objects, automatically locating elements defined using @FindBy annotations.
- Benefits: Improves code readability and reduces boilerplate code for element initialization.

Test Runner

- Configuration: Test execution is managed through two Cucumber Test Runner class (SmokeRunner and RegressionRunner), configured with Cucumber options dry runs and reports formats.

Tags: 
- Usage: Tags (@smoke, @regression) are used in feature files and Test Runner to selectively run tests based on test types or categories.

Test Steps
- For now all test steps are organized in the BasicSearchSteps.java file. This file is designed to contain step definitions performed on the search page. If in the future we need to test other pages then it would be suitable to create another file to organize those steps.


## Next steps
- Test cases for grouping results(show N results per page)
- Test cases for test results filters(search in article/discussion/etc..)
- Test cases for all advanced search parameters(file type, exact match etc..)



