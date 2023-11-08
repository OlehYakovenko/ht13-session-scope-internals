Implement @SessionScope internals

* Create a Spring Boot webapp that allows to store a current user in an HTTP session (completely the same as we did during the online training #13)
* Refactor it to preserve the same logic without using the @SessionScope (again, it's the same as we did during the training, but now it's your turn)
  * Comment @SessionScope and @Service annotations 
  * Create a proxy class for your service to handle the session-related logic 
  * Make sure you don't change the controller during refactoring
* Prep a demo showing that it works