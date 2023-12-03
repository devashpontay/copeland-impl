# copeland-impl
***This project is a REST API.*** It is an implementation of Copeland's Method, also known as Pairwise comparison, in voting theory. You can refer to this website for better understanding [CLICK HERE!](https://courses.lumenlearning.com/mathforliberalartscorequisite/chapter/copelands-method/)

> It is recommended to use IntelliJ as your IDE if you want to test this project out for yourself.

## How to use this project

Tools needed:
1. Postman
2. IntelliJ (Optional)
3. PostgresSQL
4. DBeaver (Optional)

There are two main Java Class in this project. **Election and Ballot**
<br><br>
What are the fields in Election class?
- idNo (Long)
- title (String)
- category (String)
- status (String)
- candidateCount (Integer)
- candidates (List of String)

What are the fields in Ballot class?
- idNo (Long)
- electionIdNo (Long)
- selectedCandidates (List of Integer)

-------------------------------------------------------------------------------------

Election class purpose is to start a voting session of any type. *EX: Food voting, leader voting, vacation place voting, etc.* On the other hand, Ballot class sole purpose is to hold votes for a specific voting session.

### List of implemented endpoints:
- Election
  - */api/v1/elections* | POST METHOD - To create new Election session
  - */api/v1/elections/{idNo}* | GET METHOD - To get one specific election session with ID in URI
  - */api/v1/elections/{idNo}/votes* | GET METHOD - To get all votes in the Election session with the given ID in URI
  - */api/v1/elections/{idNo}/winner* | GET METHOD - To get the winner of the Election session using the Copeland's method algorithm
- Ballot
  - */api/v1/ballots* | POST METHOD - To create new vote targeting an election session
 
<br>

> [!NOTE]
> If you are interested in improving this project, feel free to make a pull request.

