# Getting Started

# Import project in STS

+ Click `File` > `Import`
+ In the `Import` wizard
+ Expand `Git` and then click `Projects from Git`. Click `Next`.
+ Click `Existing local repository` and then click `Next`.
+ Click `Git` to choose one of the recently used repositories from the list or click `Add` to browse to any local repository.
+ Click `Next`. 
+ In the `Wizard for project import` section, click `Import existing Eclipse project`. Click `Next`.
+ In the `Import Projects` window, select all the projects that you want to import.
+ Ensure that the `Select nested projects` check box is clicked to import the nested projects under the parent project that you are importing.
+ Click `Finish`.

# How to Run

+ Select project from the project explorer
+ Mouse right button click on the project
+ Selecte `Run As` > `Spring Boot App`

# How to Run Test Cases

+ Select project from the project explorer
+ Mouse right button click on the project
+ Selecte `Run As` > `JUnit Test`

# API call

1 Get User information with their related posts 
+ API URL `http://localhost:8080/api/admin/user/{UserId}`
+ Method: GET
+ Output Type: JSON
+ Example: `http://localhost:8080/api/admin/user/1`

2 Admin user create a post on behalf of a user 
+ API URL `http://localhost:8080/api/admin/post`
+ Method: POST
+ Input: JSON
+ Output Type: JSON
+ Post data example: `{"userId": 1,"id": 100,"title": "Test Title","body": "Test Body"}`


# Requirements

Operating System  : Platform Independent(win,linux,mac etc)

Software required : Java Runtime Environment (JRE)  1.8 or JDK 1.8.

# Thank you