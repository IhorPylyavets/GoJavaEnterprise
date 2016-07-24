CREATE TABLE POSITION (
	ID SERIAL PRIMARY KEY,
	TITLE TEXT NOT NULL
);
commit;
INSERT INTO POSITION (TITLE) VALUES ('waiter');
INSERT INTO POSITION (TITLE) VALUES ('cook');
INSERT INTO POSITION (TITLE) VALUES ('manager');
INSERT INTO POSITION (TITLE) VALUES ('hookah');
INSERT INTO POSITION (TITLE) VALUES ('security guard');
SELECT * FROM POSITION;


CREATE TABLE EMPLOYEE (
	ID SERIAL PRIMARY KEY,
	LAST_NAME TEXT NOT NULL,
	FIRST_NAME TEXT NOT NULL,
	BIRTHDAY date,
	PHONE TEXT,
	POSITION_ID int NOT NULL,
	SALARY real
);
ALTER TABLE EMPLOYEE ADD CONSTRAINT POSITION_ID_FK
FOREIGN KEY (POSITION_ID) REFERENCES POSITION (ID);
commit;
INSERT INTO EMPLOYEE (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Nowitzki', 'Dirk', '19-Jun-1978', '1234567890', 1, 20000.0);
INSERT INTO EMPLOYEE (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Paul David Hewson', 'Bono', '5-May-1960', '9876543210', 2, 23000.0);
SELECT * FROM EMPLOYEE;


CREATE TABLE DESK (
  ID SERIAL PRIMARY KEY,
  NUMBER TEXT NOT NULL
);
commit;
INSERT INTO DESK (NUMBER) VALUES ('First');
INSERT INTO DESK (NUMBER) VALUES ('Second');
INSERT INTO DESK (NUMBER) VALUES ('Third');
INSERT INTO DESK (NUMBER) VALUES ('Fourth');
INSERT INTO DESK (NUMBER) VALUES ('Fifth');
SELECT * FROM DESK;


/*CREATE TABLE ORDER (
  ID SERIAL PRIMARY KEY,
  NUMBER TEXT NOT NULL,
  EMPLOYEE_ID int NOT NULL,
  DISH_LIST TEXT NOT NULL,
  DESK_ID int NOT NULL,
  ORDER_TIME date
);
ALTER TABLE ORDER ADD CONSTRAINT EMPLOYEE_ID_FK
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID);
ALTER TABLE ORDER ADD CONSTRAINT DESK_ID_FK
FOREIGN KEY (DESK_ID) REFERENCES DESK (ID);
commit;*/


CREATE TABLE INGREDIENT (
  ID SERIAL PRIMARY KEY,
	TITLE TEXT NOT NULL
);
commit;
INSERT INTO INGREDIENT (TITLE) VALUES ('potato');
INSERT INTO INGREDIENT (TITLE) VALUES ('fish');
INSERT INTO INGREDIENT (TITLE) VALUES ('pork');
INSERT INTO INGREDIENT (TITLE) VALUES ('beef');
INSERT INTO INGREDIENT (TITLE) VALUES ('eggs');
INSERT INTO INGREDIENT (TITLE) VALUES ('cheese');
INSERT INTO INGREDIENT (TITLE) VALUES ('tomatoes');
INSERT INTO INGREDIENT (TITLE) VALUES ('union');
SELECT * FROM INGREDIENT;


CREATE TABLE WAREHOUSE (
  ID SERIAL PRIMARY KEY,
	INGREDIENT_ID int NOT NULL,
	AMOUNT int
);
ALTER TABLE WAREHOUSE ADD CONSTRAINT INGREDIENT_ID_FK
FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT (ID);
commit;
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (1, 400);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (2, 20);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (3, 30);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (4, 47);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (5, 200);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (6, 49);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (7, 100);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (8, 15);
SELECT * FROM WAREHOUSE;

