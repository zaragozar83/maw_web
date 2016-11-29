USE SICDB
GO
CREATE TABLE SIC_P (
	ID BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
          NAME VARCHAR(50),
          DESCRIPTION  VARCHAR(250),
          UNIT_PRICE DECIMAL,
          MANUFACTURER VARCHAR(50),
          CATEGORY VARCHAR(50),
          CONDITION VARCHAR(50),
          UNITS_IN_STOCK BIGINT,
          UNITS_IN_ORDER BIGINT,
          DISCONTINUED BIT
		  );

GO

INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('iPhone 6s', 'Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera','500','Apple','Smartphone','New',450,0,0);
INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('iPhone 6s', 'Apple iPhone 6s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera','500','Apple','Smartphone','New',450,0,0);

INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('Dell Inspiron','Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',700,'Dell','Laptop','New',1000,0,0);
INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('Nexus 7', 'Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor',300,'Google','Tablet','New',1000,0,0);


INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('iPhone 5s', 'Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',3450,'Apple','Smartphone','New',643,0,0);
INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('iPhone 6', 'Apple iPhone 6 smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',6450,'Apple','Smartphone','New',432,0,0);

INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('Mac Book Air','Mac Book Air 13-inch Laptop (Gray) with 3rd Generation Intel Core processors',16799,'Dell','Laptop','New',723,0,0);
INSERT INTO SIC_P (NAME,DESCRIPTION, UNIT_PRICE, MANUFACTURER, CATEGORY, CONDITION,UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) VALUES ('Chrome 1', 'Google lap chrome is the lightest 13 inch laptop With a quad-core Core I7™ Pro processor',18999,'Google','Laptop','New',100,0,0);


SELECT * FROM SIC_P

---------------------------------------------------------------------------------------------------------------------

USE SICDB
GO
CREATE TABLE SIC_U (
	ID BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	NAME VARCHAR(50),
	LAST_NAME VARCHAR(250),
	MIDDLE_NAME VARCHAR(250),
	AGE INT,
	ACTIVE BIT);

GO

INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES ('Ricardo', 'Zaragoza','Solis',33,1);
INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES ('Teresa', 'Solis','Morales',55,1);
INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES ('Elia Lizeth', 'Chapa','Gonzalez',24,1);
INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES ('Alberth', 'Zaragoza','Solis',34,1);
INSERT INTO SIC_U (NAME,LAST_NAME, MIDDLE_NAME, AGE, ACTIVE) VALUES ('Bernabe', 'Zaragoza','Solis',30,1);


SELECT * FROM SIC_U