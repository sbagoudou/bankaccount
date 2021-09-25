Bank account application

Using Spring Boot, Spring Web, Hibernate, JUnit

Embedded an in-memory H2 database with two tables created automatically by hibernate. The SQL code of the database is 
CREATE TABLE ACCOUNT (
  ACCOUNT_ID INT AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR(250) NOT NULL,
  BALANCE INT NOT NULL DEFAULT 0
);

CREATE TABLE TRANSACTION_HISTORY (
  TRANSACTION_ID INT AUTO_INCREMENT PRIMARY KEY,
  ACCOUNT_ID INT NOT NULL,
  PAYEE INT NOT NULL,
  AMOUNT INT NOT NULL,
  FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ACCOUNT_ID)
);

Exposed some REST webservices to :
- create account
- add/take money from the account 
- transfer money to another bank account
- ask for a transfer history 

Example of use case : 
0. Check the in-memory database; URL : http://localhost:8080/h2-console username/password
1. Access to home page that creates a default user; URL : http://localhost:8080/
2. Call the account creation WebService with new user's username; URL : http://localhost:8080/account/MYACCOUNT
3. Make a deposit of 1000; URL : http://localhost:8080/account/deposit?username=MYACCOUNT&amount=1000
4. Take 100 amount of money; URL : http://localhost:8080/account/withdraw?username=MYACCOUNT&amount=100
5. Transfer 250 from user' account to default user's account; URL : http://localhost:8080/transfer?payer=MYACCOUNT&payee=DEFAULT_USER&amount=250
6. Check user's tranfer history; URL : http://localhost:8080/history/MYACCOUNT
