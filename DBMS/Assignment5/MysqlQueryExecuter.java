import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Use to execute mysql queries.
 * @author Rachna Jadam
 *
 */
public class MysqlQueryExecuter {
	
    private int count = 0;
	
    /**
     * It fetch all order of a specific user
     * @param userID    user Id of a user (unique for each user)
     * @return          list of orders placed by user whose user id equal to userID
     */
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
                // Allocate a database 'Connection' object
                Connection connectionInstance = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                // In MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        		
                // Allocate a 'Statement' object in the Connection
                PreparedStatement statement = connectionInstance.prepareStatement(selectQuery);
            ) {
            // Execute a SQL SELECT query, the query result
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
    
    /**
     * This method inert multiple images of product/s
     * @param productImageList    list of images that you want to add
     * @return                    numbers of images inserted
     */
    public int insertImagesOfAProduct(List<ProductImage> productImageList){
    	String insertQuery = "INSERT INTO productImage (productID, imageLocation, alternateName) values(?,?,?)";
    	try (
				Connection connectionInstance = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
				PreparedStatement statement = connectionInstance.prepareStatement(insertQuery);) {
			try {
				connectionInstance.setAutoCommit(false);
				for (ProductImage productImage : productImageList) {
					statement.setInt(1, productImage.getProductID());
					statement.setString(2, productImage.getPathOfImage());
					statement.setString(3, productImage.getAlternativeName());
					statement.addBatch();
				}

				int[] result = statement.executeBatch();
				connectionInstance.commit();
				return result.length;

			}catch (BatchUpdateException batchUpdateException) {
				//batchUpdateException.printStackTrace();
				connectionInstance.rollback();
				throw new AssertionError("Product id should present in product table ");
			} catch (SQLException ex) {
				//ex.printStackTrace();
				connectionInstance.rollback();
				throw new AssertionError("SQLException occured");
			}
		}
		// Step 5: Close the resources - Done automatically by try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
    }
    
    /**
     * It update product state as inactive which were not ordered by any Shopper
     *  in last 1 year.
     * @return    numbers of row updated by this operations
     */
    public int updateProductStatusWhichWereNotOrderedByAnyShopperInLastOneYear(){
        String deleteQuery = "UPDATE product"+ 
                " SET productState = 'Inactive' "+
                " WHERE productID NOT IN"+
                " (SELECT opr.productID FROM orderProductRelationship opr"+
                " LEFT JOIN orders o ON o.orderID = opr.orderID "+
                " WHERE o.orderPlacingDate >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)"+ 
                " GROUP BY productID)"; 
        try (
                Connection connectionInstance = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement statement = connectionInstance.prepareStatement(deleteQuery);
            ) {
            return statement.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace(); 
            return 0;
        }
    }
    
    /**
     * This method is use to find number of children of top parent categories
     * @return    list of parentCategory
     */
    public List<ParentCategory> getTopCategoryWithChildrenCount(){
        List<ParentCategory> parentCategoryList =new ArrayList<ParentCategory>();
        
        String query = "SELECT categoryID, categoryName " + 
                       "FROM category " + 
                       "WHERE parentCategoryID IS NULL " + 
                       "ORDER BY categoryName";
        
        try
        (
        		Connection connectionInstance = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement statement = connectionInstance.prepareStatement(query);
        ){
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
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return parentCategoryList;
    }
    
    /**
     * This method count sub categories of a particular category
     * @param categoryID
     * @return               number of sub category whose category id 
     */
    private int countSubCategories(int categoryID){
    	count = 0;
        String subCategoriesQuery = "SELECT categoryID " + 
                "FROM category " + 
                "WHERE parentCategoryID = ?";

        try(
        		Connection connectionInstance = JDBCConnectivity.getConnection("storeFront", "root", "r@jkum@ri");
                PreparedStatement subCategoriesStatement = connectionInstance.prepareStatement(subCategoriesQuery);
        ){
            subCategoriesStatement.setInt(1, categoryID);
            ResultSet subCategoriesSet = subCategoriesStatement.executeQuery();
            
            while(subCategoriesSet.next()){
                int subCategoryID = subCategoriesSet.getInt("categoryID");
                
                count = count + 1 + countSubCategories(subCategoryID);
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return count;
    }
}
