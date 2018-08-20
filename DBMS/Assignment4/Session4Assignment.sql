#Session 4

#Assignment 1
#Question 1
#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

DELIMITER $$
CREATE FUNCTION numbersOfOrderInAMonth(month INT,year INT) 
RETURNS INT NOT DETERMINISTIC

BEGIN

DECLARE numOfOrderInMonth INT;

SELECT COUNT(orderID) INTO numOfOrderInMonth 
FROM orders 
WHERE MONTH(orderPlacingDate) = month 
AND YEAR(orderPlacingDate) = year;

RETURN (numOfOrderInMonth);

END$$

SELECT numbersOfOrderInAMonth(08,2018);

#Question 2
# Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER $$

CREATE FUNCTION maximunOrderMonth(year INT) 
RETURNS INT DETERMINISTIC

BEGIN

DECLARE maxOrderMonth INT;

SELECT month INTO maxOrderMonth 
FROM (
     SELECT COUNT(orderID) AS orderCount, MONTH(orderPlacingDate) AS month
     FROM orders
     WHERE YEAR(orderPlacingDate) = year
     GROUP BY MONTH(orderPlacingDate)
    ) op
HAVING MAX(op.orderCount);

RETURN (maxOrderMonth);

END$$

SELECT maximunOrderMonth(2018);

#Assignment 2
#Question 1
#Create a Stored procedure to retrieve average sales of each product in a month. 
#Month and year will be input parameter to function.


DELIMITER $$
CREATE PROCEDURE getAverageSales(month INT, year INT) 

BEGIN

    SELECT productName, SUM(opr.numberOfProduct * p.price) / DAY(LAST_DAY(orderPlacingDate)) AS producAverage
    FROM orderProductRelationship as opr
    LEFT JOIN product AS p ON opr.productID = p.productID
    LEFT JOIN orders AS o ON opr.orderID = o.orderID
    WHERE MONTH(o.orderPlacingDate) = month
    AND YEAR(o.orderPlacingDate) = year
    GROUP BY opr.productID;
    
END $$
#DROP PROCEDURE getAverageSales;
CALL getAverageSales(8, 2018);

#Question 2
#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. 
#Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date.

#Checks if start date comes before end date. 
#If not the set start date to first day of the month.

DELIMITER $$ 
CREATE FUNCTION validateDate(startDate Date,endDate Date)
RETURNS DATE

BEGIN
  
    DECLARE setStartDate DATE;
  
    IF (startDate < endDate)
        THEN
        RETURN startDate;
                
    ELSE
        SET setStartDate = DATE_ADD(DATE_ADD(LAST_DAY(endDate), INTERVAL 1 DAY), INTERVAL - 1 MONTH);
        RETURN setStartDate;
    END IF;

END$$



DELIMITER $$
CREATE PROCEDURE getOrdersBetweenDates(startDate DATE, endDate DATE) 

BEGIN

    SET startDate = validateDate(startDate, endDate);

    SELECT orderID, userID, orderPlacingDate, totalNumberOfProductsOrdered, orderStatus
    FROM orders 
    WHERE orderPlacingDate BETWEEN startDate AND endDate;


END $$

CALL getOrdersBetweenDates('2018-08-21', '2018-08-18');

#Assignment 3
#Question 1
#Identify the columns require indexing in order, product, category tables and create indexes.

ALTER TABLE orders
ADD INDEX orderIndex (orderID);

ALTER TABLE product
ADD INDEX productIndex (productID);

ALTER TABLE category
ADD INDEX categoryIndex (categoryID);