INSERT INTO user(emailID, password, userName, gender, type, dateOfBirth) 
VALUES ('rachnajadam@gmail.com', 'rachna', '1234', 'f', 'administrator', '1996-02-09');
INSERT INTO user(emailID, password, userName, gender, type, dateOfBirth) 
VALUES ('rageeni@gmail.com', 'rageeni', '123456', 'f', 'shopper', '1993-11-16');


INSERT INTO userAddress(userID, street, city, state, pincode)
VALUES(1, 'Adarsh Nagar', 'Jaipur', 'Rajasthan', 305002);
INSERT INTO userAddress(userID, street, city, state, pincode)
VALUES(2, 'Nirman nagar', 'Jaipur', 'Rajasthan', 302019);

INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '1234567890', 'mobile');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '0145-123456', 'landline');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '2134567890', 'mobile');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(2, '3214567890', 'mobile');

INSERT INTO product(productName, details, rating, price, stock)
VALUES('Mi A1', 'mobile phone', 5.0, 14000.00, 100);
INSERT INTO product(productName, details, rating, price, stock)
VALUES('Fridge', 'electronic', 3.0, 23420.00, 10);

INSERT INTO productImage(productID, imageLocation, alternateName)
VALUES(1, 'C:\Users\Rachna\Pictures\MiA1.jpg', 'Mi image');

INSERT INTO category(categoryName, details, parentCategoryID)
VALUES('electronics', 'includes all electronics', NULL);
INSERT INTO category(categoryName, details, parentCategoryID)
VALUES('mobiles', 'includes all mobiles', 1);

INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(2, 1);
INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(1, 1);
INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(1, 2);

INSERT INTO orders(userID, orderPlacingDate, totalNumberOfProductsOrdered, orderStatus)
VALUES(2, '2018-08-15', 2, 'not delivered');
INSERT INTO orders(userID, orderPlacingDate, totalNumberOfProductsOrdered, orderStatus)
VALUES(2, '2018-08-16', 3, 'not delivered');

INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(1, 1, 2, 'not delivered');
INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(2, 2, 2, 'not delivered');
INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(2, 1, 1, 'not delivered');