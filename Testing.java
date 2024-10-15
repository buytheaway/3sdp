import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Facade shoppingFacade = new Facade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the online shop!");
        shoppingFacade.displayProducts();

        System.out.println("\nEnter the name of the product you want to order:");
        String productName = scanner.nextLine();

        shoppingFacade.placeOrder(productName);
    }
}
