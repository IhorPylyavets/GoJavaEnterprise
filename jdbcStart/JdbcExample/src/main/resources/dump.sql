create table EMPLOYEE (
	ID int primary key not null,
	NAME varchar(20) not null,
	AGE int not null,
	ADDRESS varchar(50),
	SALARY real,
	JOIN_DATE date
);
commit;

INSERT INTO EMPLOYEE VALUES (1, 'Paul', 32, 'California', 20000.00, '2001-08-15');
INSERT INTO EMPLOYEE VALUES (2, 'Bill', 34, 'Texas', 25000.00, '2004-01-25');
INSERT INTO EMPLOYEE VALUES (3, 'Allen', 23, 'California', 30000.00, '2009-09-05');
INSERT INTO EMPLOYEE VALUES (4, 'Teddy', 27, 'Norway', 20000.00);
INSERT INTO EMPLOYEE VALUES (5, 'Mark', 25, 'Rich-Mond', 65000.00, '2007-12-13');
INSERT INTO EMPLOYEE VALUES (6, 'David', 27, 'Texas', 85000.00, '2007-12-13');
INSERT INTO EMPLOYEE VALUES (7, 'Paul', 24, 'Houston', 20000.00, '2005-12-13');
INSERT INTO EMPLOYEE VALUES (8, 'James', 44, 'Norway', 5000.00, '2005-07-13');
INSERT INTO EMPLOYEE VALUES (9, 'James', 45, 'Texas', 5000.00, '2005-07-13');

select * from EMPLOYEE;
select * from DEPARTMENT;

create table DEPARTMENT (
	ID int primary key not null,
	NAME varchar(20) not null
);
commit;

insert into DEPARTMENT values (1, 'Engineering');
insert into DEPARTMENT values (2, 'IT');
insert into DEPARTMENT values (3, 'Finance');

alter table EMPLOYEE add column DEPARTMENT_ID int;
ALTER TABLE EMPLOYEE ADD CONSTRAINT DEPARTMENT_ID_FK FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID);
commit;

update EMPLOYEE set DEPARTMENT_ID = 1 where id < 4;
update EMPLOYEE set DEPARTMENT_ID = 2 where id >= 4 and id < 7;
update EMPLOYEE set DEPARTMENT_ID = 3 where id >= 7;

INSERT INTO EMPLOYEE VALUES (10, 'Kate', 21, 'Huston', 15000.00, '2016-07-21');
insert into DEPARTMENT values (4, 'HR');

select employee.id, employee.name, employee.address, department.name from employee
inner join department on employee.department_id = department.id
where department.name like '%i%';

select employee.id, employee.name, employee.address, department.name from employee
left join department on employee.department_id = department.id;

select employee.id, employee.name, employee.address, department.name from employee
right join department on employee.department_id = department.id;