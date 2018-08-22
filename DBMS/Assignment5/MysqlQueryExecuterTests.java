import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MysqlQueryExecuterTests {

	MysqlQueryExecuter mysqlQueryExecuter;
	@Before
	public void init() {
		mysqlQueryExecuter = new MysqlQueryExecuter();
	}
	
	@Test
	public void testFetchAllOrdersOfAUserReturnOrderListOfASpecificShopper(){
		for (Orders orders : mysqlQueryExecuter.fetchAllOrdersOfAUser(2)){
			assertEquals(1, orders.getId());
			assertTrue("2018-08-15".equals(""+orders.getOrderPlacingDate()));
			assertEquals(28000.0, orders.getTotalPrice(),0.0);
		}
		assertEquals(0, mysqlQueryExecuter.fetchAllOrdersOfAUser(4).size());
	}
	
	@Test(expected = AssertionError.class)
	public void testInsertImagesOfAProductWithInvalidProductId(){
		List<ProductImage> productImagesList = new ArrayList<ProductImage>();
		productImagesList.add(new ProductImage(7, "D:\\Images\\abc.jpg", "abc"));
		mysqlQueryExecuter.insertImagesOfAProduct(productImagesList);
	}
	
	@Test
	public void testInsertImagesOfAProductRetuenNumberOfRowsInsertedInProductImageTable(){
		List<ProductImage> productImagesList = new ArrayList<ProductImage>();
		productImagesList.add(new ProductImage(1, "D:\\Images\\abc.jpg", "abc"));
		productImagesList.add(new ProductImage(1, "D:\\Images\\def.jpg", "def"));
		productImagesList.add(new ProductImage(1, "D:\\Images\\ghi.jpg", "ghi"));
		productImagesList.add(new ProductImage(1, "D:\\Images\\jkl.jpg", "jkl"));
		productImagesList.add(new ProductImage(1, "D:\\Images\\mno.jpg", "mno"));
		assertEquals(5, mysqlQueryExecuter.insertImagesOfAProduct(productImagesList));
	}
	
	@Test
	public void testUpdateProductStatusWhichWereNotOrderedByAnyShopperInLastOneYearRetuenNumberOfRowsUpdatedInProductTable(){
		assertEquals(1, mysqlQueryExecuter.updateProductStatusWhichWereNotOrderedByAnyShopperInLastOneYear());
	}
	
	@Test
	public void testGetTopCategoryWithChildrenCount(){
		for (ParentCategory parentCategory : mysqlQueryExecuter.getTopCategoryWithChildrenCount()){
			assertEquals(1, parentCategory.getId());
			assertTrue("electronics".equals(parentCategory.getName()));
			assertEquals(1, parentCategory.getNumberOfChild());
		}
	}
}
