# Flow 1 Week 1 Review
24/08/2020 - 28/08/2020  
  
## Day 2 EX-1
Files to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day2-EX1/src/main/java/entity)  
Point database was created.  
JPQL was used in the main class to populate the database.  
1000 rows of data was verified with WorkBench.  
  
    
## Day 2 EX-2  
Customer entity was added and some customers were persisted in DB. File to be found here: [EntityTested.java](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day2-EX2/src/main/java/entity)  
  
Customer facade was added and tested with a main method in the same class. File to be found here: [CustomerFacade.java](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day2-EX2/src/main/java/dbfacade)  
  
Had to give up on jUnit tests and will consult teacher/tutor next week!  
  
    
## Day 3 
## Part one  
Files to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day3/src/main/java/rest)  
AnimalsDemo and Application config was generated automatically.  
REST was demonstrated @ localhost:8080/w1d3e1/api/animals  
  
## Part two  
Another REST endpoint was created using @Path("animal_list") and return a JSON list of strings  
  
  
## Part three  
Files to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day3/src/main/java/model)  
AnimalNoDB Classs was serialized to JSON using GSON library.  
The object was retrieved serialized and returned as a JSON string found @ localhost:8080/w1d3e1/api/animal  
  
## Part four  
Files to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day3/src/main/java/entity) and here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day3/src/main/java/rest)  
A new endpoint fetching data from the database was demonstrated @ localhost:8080/w1d3e1/api/animals_db/  
It was possible to fetch animals by the following endpoints:  
- /animals_db/animalbyid/{id}
- /animals_db/animalbytype/{type}
- /animals_db/random_animal
     
## Day 4  
  
### EX-0  
File to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week4Day4-EX-0/src/main/java/tester)  
  
All exercises were solved  
    
### EX-1  
Entity and EntityFacade class was created.  
Facade class with several methods can be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day4/src/main/java/facades)  
  
## EX-2  
Created DTO Class to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day4/src/main/java/dto)  
  
## EX-3  
REST with endpoints to be found here: [Link](https://github.com/MivleDK/3semFlow1Week1/tree/master/Week1Day4/src/main/java/rest)  
  
Endpoints exposed and demonstrated @ localhost at:  
- /api/employee/all
- /api/employee/{id}
- /api/employee/highestpaid
- /api/employee/name/{name}
  
## EX-4  
Droplet deployment was not performed.  
I was told that the configuration supplied by the school had unsafe root access issues.  
  
  
Thank you
