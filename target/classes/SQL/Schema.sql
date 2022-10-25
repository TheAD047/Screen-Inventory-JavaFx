CREATE DATABASE Screens;

USE Screens;

CREATE TABLE aspect_ratio(
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    horizontal INT NOT NULL,
    vertical INT NOT NULL
);

INSERT INTO aspect_ratio(horizontal, vertical) VALUES(16, 9);

SELECT * FROM aspect_ratio;

CREATE TABLE Screens(
	Screen_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    vertical_res INT NOT NULL,
    horizontal_res INT NOT NULL,
    screen_size DOUBLE NOT NULL,
    manufacturer VARCHAR(128) NOT NULL,
    panel_type VARCHAR(50) NOT NULL,
    wattage INT NOT NULL,
    refresh_rate INT NOT NULL
);

INSERT INTO Screens VALUES(1, 1080, 1920, 21, 'LG', 'IPS', 75, 144);

SELECT * FROM Screens;

CREATE TABLE Computer_screens(
	Screen_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    vertical_res INT NOT NULL,
    horizontal_res INT NOT NULL,
    screen_size DOUBLE NOT NULL,
    manufacturer VARCHAR(128) NOT NULL,
    panel_type VARCHAR(50) NOT NULL,
    wattage INT NOT NULL,
    refresh_rate INT NOT NULL,
    sRGB INT NOT NULL,
    response_time INT NOT NULL,
    async_type VARCHAR(50) NOT NULL,
    ratio_ID INT NOT NULL,
    FOREIGN KEY(ratio_ID) REFERENCES aspect_ratio(ID)
);

INSERT INTO Computer_screens VALUES(1, 1080, 1920, 21, 'LG', 'IPS', 75, 144, 89, 2, 'GSYNC', 1);

SELECT * FROM Computer_screens;

CREATE TABLE Mobile_screens(
	Screen_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    vertical_res INT NOT NULL,
    horizontal_res INT NOT NULL,
    screen_size DOUBLE NOT NULL,
    manufacturer VARCHAR(128) NOT NULL,
    panel_type VARCHAR(50) NOT NULL,
    wattage INT NOT NULL,
    refresh_rate INT NOT NULL,
    max_brightness INT NOT NULL,
    pixel_density INT NOT NULL,
    camera_support VARCHAR(100) NOT NULL
);

INSERT INTO Mobile_screens VALUES(1, 1080, 1920, 5.5, 'SAMSUNG', 'OLED', 15, 90, 300, 287, 'NOTCH'); 

SELECT * FROM Mobile_screens;