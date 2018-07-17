import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

	private List<Product> productList;
	private Promotion promotion;
	public ShoppingCart()
	{
		productList=new ArrayList<Product>();
	}
	
	
	/**
	 * this method adds an Product to the cart. If an Product already exists, its quantity is updated
	 * @param productName 
	 * @param price
	 * @param quantity
	 */
	public void addProduct(String productName,float productPrice,int numberOfProduct)
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
	
	
	/**
	 * this method removes an Product from the cart
	 * @param name of the product that you want to be removed
	 */
	public void removeProduct(String productName)
	{
		try{
			productList.remove(productList.indexOf(productName));
			
		}catch(Exception exception)
		{
			System.out.println("Product is not present in card");
		}
		
	}
	
	
	/**
	 * this method generates the bill of the cart Products and also applies the discount if applicable
	 * @param promoCode is the promocode as provided by user
	 */
	public void generateBill(String promoCode)
	{
		double billTotal=0;
		System.out.println("Name\t\tPrice\t\tQuantity\t\tTotal");
		for(Product product : productList)
		{
			product.showProduct();
			billTotal+=product.total();
						
		}
		System.out.println("\n\nTotal: "+billTotal);
		promotion = new FixedOrderPromotion();
		promotion.setMinimumPrice(3000);
		promotion.setFixedDiscount(15);
		double discount = applyPromotion(promotion, promoCode, billTotal);
		
		System.out.println("discount applied: "+discount+" %");
		billTotal = billTotal - ((discount/100)*billTotal);
		System.out.println("Grand Total:  " + billTotal);
	}
	
	/**
	 * this method generates the discount based on the promotion applied 
	 * @param promotion is an object of Promotion class
	 * @param code is a string having the promocode
	 * @param amount is the total amount of the Products in the cart 
	 * @return it returns the % discount that can be applied on the order
	 */
	public double applyPromotion(Promotion promotion, String code, double amount)
	{
		double discount = 0;
		if(promotion.isPromotionApplicable(code) && amount >= promotion.getMinimumPrice())
		{
			discount = promotion.getFixedDiscount();
		}
		return discount;
	}
	
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
}
