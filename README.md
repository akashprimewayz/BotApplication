# Demo Bot Application (for java 1.8 ) (tested with Java 1.8)

Technology Used

- Springdoc-openapi-ui for Documenttation
- Framework: Spring boot 2.7.1
- Packaging: maven
- Java: java 8
- Codebase versioning Github

API documentation:
-------------------

[http://localhost:8080/documentation.html](http://localhost:8080/documentation.html)

# Open API URL: http://localhost:8080/demo-openapi

Get the source code:
-------------------
Clone the repository:
     
	 $ git clone [https://github.com/akashprimewayz/BotApplication.git](https://github.com/akashprimewayz/BotApplication.git)
	 
If this is your first time using Github, review http://help.github.com to learn the basics.

You can also download the zip file containing the code from [https://github.com/akashprimewayz/BotApplication](https://github.com/akashprimewayz/BotApplication) 

To build the application:
-------------------

From the command line:

	$ cd BotApplication
	$ mvnw clean install
	$ mvnw spring-boot:run

### Access the application:
-------------------

Access the headless web application at: http://localhost:8080/swagger-ui.html

### Prerequisite
# Install Java 1.8


### Instructions

- Please use application.properties to change the port of server
  server.port=8080

- We have used jar packaging, if somebody wants to chnage the packaging then he/she needs to change/add the packaging to war in pom.xml 
<packaging>war</packaging>

- We haven't added any UI so, there is no any questions in String format like: 
   Please sum the numbers 9,5,3
   Ui needs to iterate the list and show to the user
   user have to provide an answer

- Min 2 values are required in list for sending post request.




