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