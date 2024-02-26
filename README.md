# Selenide Framework

## Purpose 🎯
The Selenide Framework is designed to automate the testing of an ecommerce demo website: [LINK](https://ecommerce.tealiumdemo.com/)

### Test Cases Covered
**Login**
* User Login
* Login - Email Validation
* Login - Password Validation

**Registration**
* User Registration
* Registration - Email Validation
* Registration - Password Validation

**E2E**
* Adding a Product to the Cart and Checking if it can be Successfully Deleted 

### Limitations
While the Selenide Framework provides comprehensive test coverage, there are some limitations to consider:
* The demo website may not always load reliably, leading to intermittent test failures
* Changes to the HTML structure of the website may cause tests to fail unexpectedly

### Skills Demonstrated in This Repository 🛠️ 
The following skills are demonstrated through the implementation of the Selenide Framework:
* Utilizing loops to handle dynamic content on product pages
* Integrating the Jackson library for parsing JSON data
* Implementationg centralized Pages class, which serves as a repository for declaring and instantiating page classes through constructors
This approach enhances code readability and enables an easy access to methods and objects related to a specific page
* Locating web elements via css selectors and xpath expressions 
* Utilizing well-defined methods that enable concise and efficient execution of multiple actions within a single line of code in the test class
* Incorporating the use of constants to represent relative paths and URL, ensuring clarity and maintainability in the codebase by centralizing key values 

## Files Overview 📁

### "data" package
The data package contains classes that are necessary for retrieving data from the JSON files

### "pages" package
The pages package contains classes representing different pages of the ecommerce website. Each page class encapsulates the functionality and elements of its respective page

### "tests" package
The tests package contains test classes that validate various functionalities of the ecommerce website using Selenide

### "testData" package
The testData package contains JSON files used for parsing data

## How to Run Tests

1. Clone the repository to your local machine
2. Ensure that the required dependencies, such as Selenide, testNG, Jackson and Lombok, are installed. For reference, take a look at the pom file
The dependencies will be automatically downloaded when you build the project with Maven

### Setting Up Demo User Credentials
To run the automated tests, you'll need to set up your own demo user credentials on the [demo site](https://ecommerce.tealiumdemo.com/). 
Follow these steps:

**1. Register a New User:**
* Navigate to the demo site
* Click on the "Create an Account" button
* Fill in the mandatory fields and click on the "Register" button

**2. Replace Placeholders in the JSON files:**
  * Go to the resource and then testData package
  * Select the UserData.json file
  * Replace these placeholders with your user's registered email address and password
 
Now you're ready to run the automated tests using your own demo user credentials

### Note on Chromedriver

Selenide is built on top of Selenium WebDriver and provides additional functionality and a more user-friendly API for writing tests 
Selenide handles the WebDriver management internally and typically downloads the appropriate WebDriver binaries automatically based on the browser you are using

However, sometimes Selenide may not be able to automatically download the WebDriver binaries, especially if you're using a less common browser or a specific version.
In such cases, you may need to manually provide the path to the WebDriver binary using the **webdriver.chrome.driver** system property, similar to how you would with Selenium WebDriver directly

You can download the chromedriver.exe file [here](https://googlechromelabs.github.io/chrome-for-testing/) 








