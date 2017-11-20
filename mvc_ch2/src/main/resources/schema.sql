CREATE TABLE PRODUCTS (
ID VARCHAR(25) PRIMARY KEY,
NAME VARCHAR(50),
DESCRIPTION VARCHAR(250),
UNIT_PRICE DECIMAL,
MANUFACTURER VARCHAR(50),
CATEGORY VARCHAR(50),
CONDITION1 VARCHAR(50),
UNITS_IN_STOCK BIGINT,
UNITS_IN_ORDER BIGINT,
DISCONTINUED BOOLEAN
);

INSERT INTO PRODUCTS VALUES ('P1234', 'iPhone 6s', 'Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8- megapixel rear camera','500','Apple','Smartphone','New',450,0,false);
INSERT INTO PRODUCTS VALUES ('P1235', 'Dell Inspiron', 'Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',700,'Dell','Laptop','New',1000,0,false);
INSERT INTO PRODUCTS VALUES ('P1236', 'Nexus 7', 'Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor', 300,'Google','Tablet','New',1000,0,false);

CREATE TABLE CUSTOMERS (
ID VARCHAR(25) PRIMARY KEY,
NAME VARCHAR(50),
ADDRESS VARCHAR(50),
NOOFORDERSMADE BIGINT
);

insert into customers values ('Kyoko','Kyoko','Tokyo',0);
insert into customers values ('Kyoko1','Kyoko1','Tokyo1',1);
insert into customers values ('Kyoko2','Kyoko2','Tokyo2',2);
insert into customers values ('Kyoko3','Kyoko3','Tokyo3',3);