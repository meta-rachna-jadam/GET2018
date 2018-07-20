
public class Product {
	private String productName;
	private float productPrice;
	private int  numberOfProduct;
	private boolean isProductBasePromotionApplicable;
	public Product(String productName,float productPrice,int numberOfProduct)
	{
		this.productName=productName;
		this.numberOfProduct=numberOfProduct;
		this.productPrice=productPrice;
	}
	public String getProductName()
	{
		return productName;
	}
	public int getNumberOfProduct()
	{
		return numberOfProduct;
	}
	public float getProductPrice()
	{
		return productPrice;
	}
	public void  setnumberOfProduct(int numberOfProduct)
	{
		this.numberOfProduct=numberOfProduct;
	}
	public double total()
	{
		return productPrice*numberOfProduct;
	}
	public void showProduct(boolean isPromotionApplicable)
	{
		if(isPromotionApplicable){
			System.out.println(productName+"\t\t"+productPrice+"\t\t"+numberOfProduct+"\t\t\t"+total()+
					"\t\t2%\t\tFinal Amount"+totalWithDiscount());
		}
		else {
			System.out.println(productName+"\t\t"+productPrice+"\t\t"+numberOfProduct+"\t\t\t"+total());
		}
		
	}
	private double totalWithDiscount() {
		return ((productPrice*numberOfProduct*2)/100);
	}


}
