INSERT INTO POSITIONS (POSITION_TITLE) VALUES ('waiter');
INSERT INTO POSITIONS (POSITION_TITLE) VALUES ('cook');
INSERT INTO POSITIONS (POSITION_TITLE) VALUES ('manager');
INSERT INTO POSITIONS (POSITION_TITLE) VALUES ('hookah');
INSERT INTO POSITIONS (POSITION_TITLE) VALUES ('security guard');
SELECT * FROM POSITIONS;

INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Ivanov', 'Ivan', '1978-06-19', '1234567890', 1, 20000.0);
INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Petrov', 'Piter', '1960-05-05', '9876543210', 2, 23000.0);
INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Green', 'Alex', '1980-05-13', '09877763310', 3, 33000.0);
INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Teddy', 'BigTeddy', '1989-06-19', '05088221797', 4, 35000.0);
INSERT INTO EMPLOYEES (LAST_NAME, FIRST_NAME, BIRTHDAY, PHONE, POSITION_ID, SALARY)
VALUES ('Petrov', 'Vasilii', '1976-05-21', '06777991102', 5, 29000.0);
SELECT * FROM EMPLOYEES;
SELECT EMPLOYEES.ID, EMPLOYEES.LAST_NAME, EMPLOYEES.FIRST_NAME, EMPLOYEES.BIRTHDAY, EMPLOYEES.PHONE, POSITIONS.POSITION_TITLE, EMPLOYEES.SALARY  FROM EMPLOYEES
INNER JOIN POSITIONS on EMPLOYEES.POSITION_ID = POSITIONS.ID;

INSERT INTO DESKS (DESK_TITLE, STATUS_OF_DESK) VALUES ('First', 'FREE');
INSERT INTO DESKS (DESK_TITLE, STATUS_OF_DESK) VALUES ('Second', 'FREE');
INSERT INTO DESKS (DESK_TITLE, STATUS_OF_DESK) VALUES ('Third', 'FREE');
INSERT INTO DESKS (DESK_TITLE, STATUS_OF_DESK) VALUES ('Fourth', 'ORDERED');
INSERT INTO DESKS (DESK_TITLE, STATUS_OF_DESK) VALUES ('Fifth', 'FREE');
SELECT * FROM DESKS;

INSERT INTO MENUS (MENU_TITLE) VALUES ('Menu Business Lunch');
INSERT INTO MENUS (MENU_TITLE) VALUES ('Buffet');
INSERT INTO MENUS (MENU_TITLE) VALUES ('Table d*hote menu');
INSERT INTO MENUS (MENU_TITLE) VALUES ('Menu a la carte');
SELECT * FROM MENUS;

INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('potato');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('fish');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('pork');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('beef');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('eggs');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('cheese');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('tomatoes');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('union');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('duck');
INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES ('apple');
SELECT * FROM INGREDIENTS;

INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (1, 400);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (2, 20);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (3, 30);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (4, 47);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (5, 200);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (6, 49);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (7, 100);
INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (8, 15);
SELECT * FROM WAREHOUSE;
SELECT WAREHOUSE.ID, INGREDIENTS.INGREDIENT_TITLE, WAREHOUSE.AMOUNT FROM WAREHOUSE
INNER JOIN INGREDIENTS on WAREHOUSE.INGREDIENT_ID = INGREDIENTS.ID;

INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES ('meat');
INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES ('fruit');
INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES ('salads');
INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES ('juices');
INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES ('alcohol');
SELECT * FROM CATEGORIES;

INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Chop', 1, 54, 220);
INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Grapes', 2, 31, 300);
INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Olivie', 3, 35, 200);
INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Apple juice', 4, 20, 250);
INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Vodka', 5, 50, 500);
INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES ('Duck with apples', 1, 70, 500);
SELECT * FROM DISHES;
SELECT DISHES.ID, DISHES.DISHE_TITLE, CATEGORIES.CATEGORY_TITLE, DISHES.PRICE, DISHES.WEIGHT FROM DISHES
INNER JOIN CATEGORIES on DISHES.CATEGORY_ID = CATEGORIES.ID;

INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (3, 1);
INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (3, 5);
INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (3, 7);
INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (3, 8);
INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (6, 9);
INSERT INTO DISHES_INGREDIENTS (DISHES_ID, INGREDIENTS_ID) VALUES (6, 10);
SELECT * FROM DISHES_INGREDIENTS;
SELECT DISHES_INGREDIENTS.ID, DISHES.DISHE_TITLE, INGREDIENTS.INGREDIENT_TITLE FROM DISHES_INGREDIENTS
INNER JOIN DISHES on DISHES_INGREDIENTS.DISHES_ID = DISHES.ID
INNER JOIN INGREDIENTS on DISHES_INGREDIENTS.INGREDIENTS_ID = INGREDIENTS.ID;

INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 3);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 2);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 3);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 4);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 5);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (1, 6);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 3);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 2);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 3);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 4);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 5);
INSERT INTO MENUS_DISHES (MENUS_ID, DISHES_ID) VALUES (2, 6);
SELECT * FROM MENUS_DISHES;
SELECT MENUS_DISHES.ID, MENUS.MENU_TITLE, DISHES.DISHE_TITLE FROM MENUS_DISHES
INNER JOIN MENUS on MENUS_DISHES.MENUS_ID = MENUS.ID
INNER JOIN DISHES on MENUS_DISHES.DISHES_ID = DISHES.ID;

INSERT INTO ORDERS (EMPLOYEE_ID, DESK_ID, ORDER_DATE)
VALUES (1, 1, '2016-07-25 10:34:09');
INSERT INTO ORDERS (EMPLOYEE_ID, DESK_ID, ORDER_DATE)
VALUES (1, 3, '2016-07-25 11:42:19');
INSERT INTO ORDERS (EMPLOYEE_ID, DESK_ID, ORDER_DATE)
VALUES (1, 5, '2016-07-25 17:31:08');
SELECT * FROM ORDERS;
SELECT ORDERS.ID, EMPLOYEES.LAST_NAME, DESKS.DESK_TITLE, ORDERS.ORDER_DATE FROM ORDERS
INNER JOIN EMPLOYEES on ORDERS.EMPLOYEE_ID = EMPLOYEES.ID
INNER JOIN DESKS on ORDERS.DESK_ID = DESKS.ID;

INSERT INTO DISHES_ORDERS (DISHES_ID, ORDER_ID) VALUES (3, 1);
INSERT INTO DISHES_ORDERS (DISHES_ID, ORDER_ID) VALUES (4, 1);
INSERT INTO DISHES_ORDERS (DISHES_ID, ORDER_ID) VALUES (6, 1);
INSERT INTO DISHES_ORDERS (DISHES_ID, ORDER_ID) VALUES (1, 2);
INSERT INTO DISHES_ORDERS (DISHES_ID, ORDER_ID) VALUES (5, 2);
SELECT * FROM DISHES_ORDERS;
SELECT DISHES_ORDERS.ID, DISHES.DISHE_TITLE, ORDERS.DESK_ID, ORDERS.ORDER_DATE FROM DISHES_ORDERS
INNER JOIN DISHES on DISHES_ORDERS.DISHES_ID = DISHES.ID
INNER JOIN ORDERS on DISHES_ORDERS.ORDER_ID = ORDERS.ID;


INSERT INTO DISHES_PREPARATION (DISHES_ID, EMPLOYEE_ID, ORDER_ID, DATE_PREPARATIONS)
VALUES (3, 2, 1, '2016-07-25 10:41:09');
SELECT * FROM DISHES_PREPARATION;
SELECT DISHES_PREPARATION.ID, DISHES.DISHE_TITLE, EMPLOYEES.FIRST_NAME, ORDERS.DESK_ID, DISHES_PREPARATION.DATE_PREPARATIONS FROM DISHES_PREPARATION
INNER JOIN DISHES on DISHES_PREPARATION.DISHES_ID = DISHES.ID
INNER JOIN EMPLOYEES on DISHES_PREPARATION.EMPLOYEE_ID = EMPLOYEES.ID
INNER JOIN ORDERS on DISHES_PREPARATION.ORDER_ID = ORDERS.ID;
