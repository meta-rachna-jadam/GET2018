import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MysqlQueryExecuter {
	
    private int count = 0;
	
    public List<Orders> fetchAllOrdersOfAUser(int userID) {

    	List<Orders> orderList = new ArrayList<Orders>();
        /*Query:- Given the id of a user, fetch all orders (Id, Order Date, Order Total)
         *of that user which are in shipped state. Orders should be sorted by order date
         *column in chronological order.*/
        String selectQuery = "SELECT o.orderID, o.orderPlacingDate, SUM(p.price * opr.numberOfProduct) AS orderTotal"+
                " FROM orders AS o LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID"+
                " LEFT JOIN product AS p ON opr.productID = p.productID"+
                " LEFT JOIN user AS u ON o.userID = u.userID"+
                " WHERE u.userID = "+userID+" AND o.orderStatus = 'shipped'"+
                " GROUP BY o.orderID"+
                " ORDER BY o.orderPlacingDate";
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                // In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        		
                // Step 2: Allocate a 'Statement' object in the Connection
                PreparedStatement statement = conn.prepareStatement(selectQuery);
            ) {
            // Step 3: Execute a SQL SELECT query, the query result
            // is returned in a 'ResultSet' object.
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) { 
            	orderList.add(new Orders(resultSet.getInt("orderID"), resultSet.getDate("orderPlacingDate"), resultSet.getFloat("orderTotal")));
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return orderList;
    }
    
    public int insertImagesOfAProduct(List<ProductImage> productImageList){
    	String insertQuery = "INSERT INTO productImage (productID, imageLocation, alternateName) values(?,?,?)";
    	try (
				Connection conn = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
				PreparedStatement statement = conn.prepareStatement(insertQuery);) {
			try {
				conn.setAutoCommit(false);
				for (ProductImage productImage : productImageList) {
					statement.setInt(1, productImage.getProductID());
					statement.setString(2, productImage.getPathOfImage());
					statement.setString(3, productImage.getAlternativeName());
					statement.addBatch();
				}

				int[] result = statement.executeBatch();
				conn.commit();
				return result.length;

			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
				return 0;
			}
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Occurs");
			return 0;
		}
    }
    
    public int updateProductStatusWhichWereNotOrderedByAnyShopperInLastOneYear(){
        String deleteQuery = "UPDATE product"+ 
                " SET productState = 'Inactive' "+
                " WHERE productID NOT IN"+
                " (SELECT opr.productID FROM orderProductRelationship opr"+
                " LEFT JOIN orders o ON o.orderID = opr.orderID "+
                " WHERE o.orderPlacingDate >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)"+ 
                " GROUP BY productID)"; 
        try (
                Connection conn = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement statement = conn.prepareStatement(deleteQuery);
            ) {
        	System.out.println("The SQL query is: " + deleteQuery);
            return statement.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace(); 
            return 0;
        }
    }
    
    public List<ParentCategory> getTopCategoryWithChildrenCount()
    {
        List<ParentCategory> parentCategoryList =new ArrayList<ParentCategory>();
        
        String query = "SELECT categoryID, categoryName " + 
                       "FROM category " + 
                       "WHERE parentCategoryID IS NULL " + 
                       "ORDER BY categoryName";
        
        try
        (
        		Connection conn = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement statement = conn.prepareStatement(query);
        )
        {
            ResultSet topCategories = statement.executeQuery();
            while(topCategories.next())
            {
                int topCategoryID = topCategories.getInt("categoryID");
                String topCategoryName = topCategories.getString("categoryName");
                int subCategoriesCount = countSubCategories(topCategoryID);
                
                ParentCategory category = new ParentCategory(topCategoryID, topCategoryName, subCategoriesCount);
                parentCategoryList.add(category);
            }
        } 
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return parentCategoryList;
    }
    

    private int countSubCategories(int categoryID)
    {
        String subCategoriesQuery = "SELECT categoryID " + 
                "FROM category " + 
                "WHERE parentCategoryID = ?";

        try(
        		Connection conn = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement subCategoriesStatement = conn.prepareStatement(subCategoriesQuery);
        )
        {
            subCategoriesStatement.setInt(1, categoryID);
            ResultSet subCategoriesSet = subCategoriesStatement.executeQuery();
            
            while(subCategoriesSet.next())
            {
                int subCategoryID = subCategoriesSet.getInt("categoryID");
                
                count = count + 1 + countSubCategories(subCategoryID);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
}
