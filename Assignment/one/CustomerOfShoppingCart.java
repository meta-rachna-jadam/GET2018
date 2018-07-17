import java.util.Scanner;


public class CustomerOfShoppingCart {
	
	public static void main(String ar[])
	{
		ShoppingCart cart=new ShoppingCart();
		Scanner scanner=new Scanner(System.in);
		int choise=1;
		do{
				
			try{
				System.out.println("Press 1 for Add item in cart");
				System.out.println("Press 2 for remove item in cart");
				System.out.println("Press 3 for generate bill");
				System.out.println("Press 4 for exit");
				System.out.println("Chose any one");
				choise=scanner.nextInt();
				switch (choise) {
				case 1:
					System.out.println("Enter product name");
					String productName =scanner.next();
					System.out.println("Enter product price");
					float productPrice =scanner.nextFloat();
					System.out.println("Enter product quantity");
					int numberOfProduct =scanner.nextInt();
					cart.addItem(productName, productPrice, numberOfProduct);
					break;
	
				case 2:
					System.out.println("Enter Name of product that you want to remove");
					String removeProductName=scanner.next();
					cart.remove(removeProductName);
					break;
				case 3:
					cart.generateBill();
					break;
				case 4:
				default:
					java.lang.System.exit(0);
				}
			}catch(Exception ex)
			{
				System.out.println("Invalid Input");
			}
			
		}while(choise!=4);
	}

}
