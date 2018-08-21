#Question 2
#1
SOURCE C:/Users/Rachna/Desktop/DBMS/insertValues.sql;

#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.

SELECT p.productID, p.productName, c.categoryName, p.price
FROM product AS p, categoryProductRelationship AS cpr
LEFT JOIN category AS c ON cpr.categoryID = c.categoryID
WHERE p.productID = cpr.productID AND p.productState = 'Active'
ORDER BY productID DESC;

#Display the list of products which don't have any images.
SELECT p.productID, p.productName, p.details, p.rating, p.price, p.stock
FROM product AS p
WHERE p.productID NOT IN (
                          SELECT productID
                          FROM productImage
                          );
                          
#Display all Id, Title and Parent Category Title for all the Categories listed, 
#sorted by Parent Category Title and then Category Title. 
#(If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT child.categoryID, child.categoryName,
IFNULL(parentCategory.categoryName, 'Top Category') AS parentCategoryName
FROM category AS child
LEFT JOIN category AS parentCategory
ON child.parentCategoryId = parentCategory.categoryID
ORDER BY child.categoryName, parentCategoryName;

#Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)

SELECT c.categoryID, c.categoryName, pc.CategoryName
FROM category AS c
LEFT JOIN category AS pc
ON c.parentCategoryId = pc.categoryID
WHERE c.parentCategoryID IS NOT NULL;

#Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT p.productName, p.price, p.details
FROM product AS p
WHERE p.productID IN (
                      SELECT pcr.productID
                      FROM categoryProductRelationship AS pcr
                      INNER JOIN category AS c
                      ON pcr.categoryID = c.categoryID
                      WHERE c.categoryName = 'mobiles'
                     );
                     
#Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT productName
FROM product
Where stock < 50;

#Increase the Inventory of all the products by 100.

UPDATE product
SET stock = stock + 100;

#SELECT * FROM product;
