import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
	
	private List<Product> productList;
	
	public ShoppingCart()
	{
		productList=new ArrayList<Product>();
	}
	
	public void addItem(String productName,float productPrice,int numberOfProduct)
	{
		boolean isProductExistInList=false;
		for(Product product:productList)
		{
			if(product.getProductName().equalsIgnoreCase(productName))
			{
				isProductExistInList=true;
				product.setnumberOfProduct(product.getNumberOfProduct()+numberOfProduct);
				break;
			}
		}
		if(!isProductExistInList)
		{
			Product newProduct=new Product(productName, productPrice, numberOfProduct);
			productList.add(newProduct);
		}
		
	}
	public void remove(String productName)
	{
		try{
			productList.remove(productList.indexOf(productName));
			
		}catch(Exception exception)
		{
			System.out.println("Product is not present in card");
		}
		
	}
	public void generateBill()
	{
		double billTotal=0;
		System.out.println("Name\t\tPrice\t\tQuantity\t\tTotal");
		for(Product product : productList)
		{
			product.showProduct();
			billTotal+=product.total();
			
		}
		System.out.println("\n\nGrand Total: "+billTotal);
	}

}
