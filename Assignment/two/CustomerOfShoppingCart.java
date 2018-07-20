

import java.util.Scanner;

public class CustomerOfShoppingCart {

	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do
		{
			try{
				System.out.println("Press 1 to add item to cart");
				System.out.println("Press 2 to remove item from cart");
				System.out.println("Press 3 to generate bill");
				System.out.println("Press 4 or other for exit");
				System.out.println("Chose any one :");
				choice = scanner.nextInt();
				String  productName;
				
				switch(choice)
				{
				case 1: System.out.println("Enter the product name");
						productName = scanner.next();
						System.out.println("Enter the product price");
						float price = scanner.nextFloat();
						System.out.println("Enter the product quantity");
						int quantity = scanner.nextInt();
						cart.addProduct(productName, price, quantity);
						break;
						
				case 2: System.out.println("Enter the product name that you want to be remove:");
						productName = scanner.next();
						cart.removeProduct(productName);
						break;
						
				case 3: System.out.println("Do you have a promo code?(y/n)");
						char response = scanner.next().charAt(0);
						String promoCode = "";
						if(response == 'y')
						{
							System.out.println("Enter the promo code");
							promoCode = scanner.next();
						}
						cart.generateBill(promoCode);
						break;
						
				case 4: 
				default: System.exit(0);
				
				}
			}catch(Exception exception)
			{
				System.out.println("Please enter valid input");
			}
			
		}while(true);

	}

}
