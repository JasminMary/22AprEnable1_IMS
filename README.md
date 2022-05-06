Coverage:

## Inventory Management System 

Hello! This is a project to create, read, update and delete customers, items or orders from an inventory management application. The purpose of this project is to put into practice what we have learnt over the past 5 weeks with QA academy and show that we can implement the skills we have learnt. To complete the project we had to use our training in Java, databases(mySQL), version source control and the agile methodology.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The first prerequisite for development and testing is java - any version over 1.8 should work with this project. Here’s a link for Java 14: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html

Secondly, you’ll need an java compatible IDE, I’m currently using eclipse for java developers: https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers

Finally is Maven, a build automation tool: https://maven.apache.org/download.cgi
This can also be found on the eclipse marketplace. 


### Installing

To install this project, download it, then open into an eclipse workspace. To do this, navigate to File/Open Projects from File System within eclipse and then select the project folder. This should then give you access to the files within the project. To run the project from the eclipse console, navigate to the runner class (which should be this: src/main/java/com.qa.ims) then right click and select ‘run as’ followed by ‘Java application’. You should now be able to demo the application.

## Running the tests

To run the tests you can right click on the folder location and ‘Run as’ a ‘JUnit test or you can ‘Run as’ a ‘JUnit test on the individual test files. Coverage can also be displayed by right clicking the folder and selecting ‘coverage as’ then ‘JUnit test’.
Running the tests:
![image](https://user-images.githubusercontent.com/89535920/167155339-3e42a266-49d4-403c-91e2-19ec90cda0b9.png)

Checking coverage: 

![image](https://user-images.githubusercontent.com/89535920/167154418-c6bd0fed-cdf4-488e-a60d-b416d7995a4f.png)

### Unit and Integration Tests 

The unit tests covered the data access objects(DAO) ability to be able to create, read, update and delete a customer, item or order with test SQL data and schemas. While the integration tests, tested the controllers ability to be able to get the information and then use CRUD functionality for the customers, items and orders.

## Deployment

To deploy, run using "java -jar.ims-0.0.1-SNAPSHOT-jar-with-dependancies", while in the target folder of the project from any command line interface.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

Thank you to all the trainers we've had to teach us a QA!!! And also to Richard Mansworth for being able to spot my SQL syntax errors!

## Jira Board
https://jasminw.atlassian.net/jira/software/projects/IMS/boards/3/roadmap
