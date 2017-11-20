INSERT INTO USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ROLE) VALUES ('user', '$2a$11$3D2Upsiw7w2mPJ3WDEaPMOC.3eCVZ0Nirs8CxOlH/G15yxW9qNnNG', 'Bob', 'Sponge', 'ROLE_USER');
INSERT INTO USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ROLE) VALUES ('admin', '$2a$11$3D2Upsiw7w2mPJ3WDEaPMOC.3eCVZ0Nirs8CxOlH/G15yxW9qNnNG', 'Max', 'Grishko', 'ROLE_ADMIN'); /*password 123 */

INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Cutting wheel 3AK 125 x 1.6 x 22.23', 'Steel, 80 m/s, Type 41', '10', '/resources/images/zak125x1,6.png');
INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Grinding wheel Bosch 125 x 6.0 x 22.23', 'Steel, 80 m/s, Type 27', '15', '/resources/images/bosch125x6.jpg');
INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Cutting wheel Titan 180 x 2.0 x 22.23', 'Steel, 80 m/s, Type 41', '20', '/resources/images/titan180x2.jpg');
INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Cutting wheel 3AK 230 x 2.0 x 22.23', 'Steel, 80 m/s, Type 41', '25', '/resources/images/zak230x2.jpg');
INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Cutting wheel 3AK 300 x 3.0 x 32', 'Steel, 80 m/s, Type 41', '50', '/resources/images/zak300x3.jpg');
INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE, ICON) VALUES ('Cutting wheel NovoAbrasive 180 x 2.0', 'Stone/Concrete 80 m/s, Type 41', '23', '/resources/images/nov180x2stone.jpg');

-- INSERT INTO ORDERS (USER_ID) VALUES (1);
-- INSERT INTO ORDERS (USER_ID) VALUES (1);
-- INSERT INTO ORDERS (USER_ID) VALUES (2);
--
-- INSERT INTO ITEM_IN_ORDER (ITEM_ID, ORDER_ID) VALUES (1, 1);
-- INSERT INTO ITEM_IN_ORDER (ITEM_ID, ORDER_ID) VALUES (2, 1);
-- INSERT INTO ITEM_IN_ORDER (ITEM_ID, ORDER_ID) VALUES (5, 2);
--
-- INSERT INTO ITEM_IN_ORDER (ITEM_ID, ORDER_ID) VALUES (3, 3);
-- INSERT INTO ITEM_IN_ORDER (ITEM_ID, ORDER_ID) VALUES (4, 3);
