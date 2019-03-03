CREATE DATABASE Task0;

USE Task0;

CREATE TABLE Orders
(
  orderId     INT PRIMARY KEY
);

CREATE TABLE Purchasers
(
  purchaserId INT PRIMARY KEY,
  orderId     INT REFERENCES Orders,
  name        VARCHAR(255),
  surname     VARCHAR(255),

  FOREIGN KEY fk_orderPurchaser (orderId) REFERENCES Orders (orderId)
);

ALTER TABLE Purchasers
  DROP FOREIGN KEY fk_orderPurchaser;

ALTER TABLE Purchasers
  ADD FOREIGN KEY fk_orderPurchaser(orderId) REFERENCES Orders (orderId);

CREATE TABLE Services
(
  serviceId INT PRIMARY KEY,
  name      VARCHAR(150),
  price     DOUBLE,
  orderId   INT,

  FOREIGN KEY fk_orderServices (orderId) REFERENCES Orders (orderId)
);

ALTER TABLE Services
  DROP FOREIGN KEY fk_orderServices;

ALTER TABLE Services
  ADD FOREIGN KEY fk_orderServices(orderId) REFERENCES Orders (orderId);


SELECT * FROM Orders;

SELECT * FROM Purchasers;

SELECT * FROM Services;

INSERT Purchasers(name, surname) VALUES ('Jan','Kowalski');

INSERT INTO Orders () VALUE ();

UPDATE Purchasers SET name = 'dupa', surname = 'dupaduppa' WHERE purchaserId = 1