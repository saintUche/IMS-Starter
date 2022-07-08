
# Software Core Fundamental Project

This repository contains my deliverable for the QA software fundamental project.

### Project Brief

The brief for this project was to design and produce an application that an end user can interact with via a CLI. The application needed to be an inventory management system that can carry out the following functions:
•	Add a customer to the system
•	View all customers in the system
•	Update a customer in the system
•	Delete a customer in the system.
•	Add an item to the system
•	View all items in the system
•	Update an item in the system
•	Delete an item in the system
•	Create an order in the system.
•	View all orders in the system.
•	Delete an order in the system
•	Add an item to an order.
•	Calculate a cost for an order.
•	Delete an item in an order



## APP DESIGN

UML design shows how classes are related. The user user interacts in the same way and they all follow a the same order of instructions. First, the given object must be defined in its object class. If the object is to be interacted with it is done so through the item controller where the user decides which CRUD action to perform. The object DAO class then send querys to the database to carry out the CRUD task. 


The logic for the ER diagram is as follows.

Order table:
The Order descripton states that every order must have a customer. hence customer_id is a foreign key that references the cutomer_ ID in the customer table.
Must be able to read all items in an order so the items and item ids are stored in the table as readable strings.
The order must have a cost which can is calculated by getting item ids int the item_ids column 

Customer:
Each customer must have a name.

Item: 
Each item must have a name and a cost 


### CI interface

In addition to the above requirements, the project required the implementation of several stages of a typical CI pipeline. These were project tracking, version control, development environment and build server. For project tracking agile was used to create a Kanban board. Story points and labels were assigned to each item. Here is a look at a the kanban board created when a sprint for item section was created.

![image](https://user-images.githubusercontent.com/79328765/178010489-30990014-2d89-4d1a-a294-36142f630ced.png)


For version control, git was used, with the project repository hosted on github. Version control via git allows changes to the project to be made and committed whilst keeping the commit history for access to earlier versions. GitHub as a repository hosting service allows the repository to be stored away from the development environment, as well as providing webhooks, which send http POST requests to the build server to automate building and testing.

The Databse was in SQL and back-end programming was done in java and the build tool used was Maven.  Maven is chiefly used for Java-based projects, helping to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of separate packages.



### Risk assement

Prior to building the app, a risk assessment was undertaken to identify risks and propose measures to control these risks. These measures could then be implemented in the app. This initial risk assessment is shown below:

![image](https://user-images.githubusercontent.com/79328765/178010104-97ab3b50-6635-4d83-94a1-722e2eda7129.png)

As this is simple program hosted on the local machine there were not many risks involved in building the program.




### Testing

Testing the ims was an essential part of the development process. Two types of testing were implemented:

Unit testing tests units of functionality (i.e functions) within the app. Unit tests were written for create, read, update and delete functionality, to ensure that these worked as intended.
Integration testing tests the function of the app in an as-live environment, being able to simulate keyboard input and mouse clicks to ensure that these elements of the app function as intended. Integration tests were written for many of the forms employed in the app.

JUnit is the testing framework that is extensively used for java projects built in the maven project format for unit testing purposes.
JUnit was used to test the DAO files and checked to see if the database queries functioned as expected. 

Mockito is a mocking framework, JAVA-based library that is used for effective unit testing of JAVA applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
Mockito was used to test the controller classes and checked to see if the CRUD actions performed gave the expected outputs. 

EqualsVerifier can be used in JUnit unit tests to verify whether the contract for the equals and hashCode methods is met.
EqualsVerifier was used to test the class methods.

![image](https://user-images.githubusercontent.com/79328765/178016687-ad130502-29ee-435b-a289-0060bf87dc82.png)



Test coverage shows that 93% of tests passed. 



### The ims system 

Here is an example of user interacting with item entity
![image](https://user-images.githubusercontent.com/79328765/178008983-8e43d3b3-1403-43ca-bb94-aa5a13a36211.png)

The user has chosen to read items and they are displayed

Here is an example of user interacting with order entity
![image](https://user-images.githubusercontent.com/79328765/178009446-2d150f29-0983-42ed-ab28-bd7b23146156.png)

The user has created an order and when the order table is read you can see the order has been saved to the database with the corresponding information 

### Future work
In the future I would like to get on to creating a log in system for user.
I would like to try an implete a different database scheme which has a forth table orderline(id, FK(order id), FK(customer id), itemid)


## Links 

* **Jira** - https://ucheegbon.atlassian.net/jira/software/projects/IMS2/settings/details

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Uche Egbon** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments


