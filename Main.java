import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ProductCatalog {
    private Map<String, Double> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put("Laptop", 999.99);
        products.put("Phone", 599.99);
        products.put("Headphones", 199.99);
        products.put("Smartwatch", 299.99);
    }

    public Double searchProduct(String productName) {
        return products.get(productName);
    }

    public boolean productExists(String productName) {
        return products.containsKey(productName);
    }

    public void displayProducts() {
        System.out.println("Available products:");
        for (String product : products.keySet()) {
            System.out.println(product + ": $" + products.get(product));
        }
    }
}

class PaymentProcessor {
    public boolean processPayment(String product, double amount) {
        System.out.println("Payment of $" + amount + " for " + product + " processed.");
        return true;
    }
}

class InventoryManager {
    public boolean checkStock(String product) {
        System.out.println(product + " is in stock.");
        return true;
    }

    public void updateInventory(String product) {
        System.out.println(product + " inventory updated.");
    }
}

class ShippingService {
    public double calculateShipping(String product) {
        return 5.99;
    }

    public void shipProduct(String product) {
        System.out.println(product + " has been shipped.");
    }
}

public class Main {
    public static void main(String[] args) {
        ProductCatalog productCatalog = new ProductCatalog();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        InventoryManager inventoryManager = new InventoryManager();
        ShippingService shippingService = new ShippingService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the online shop!");
        productCatalog.displayProducts();

        System.out.println("\nEnter the name of the product you want to order:");
        String productName = scanner.nextLine();

        if (productCatalog.productExists(productName)) {
            Double productPrice = productCatalog.searchProduct(productName);

            if (inventoryManager.checkStock(productName)) {
                double shippingCost = shippingService.calculateShipping(productName);
                double totalCost = productPrice + shippingCost;

                if (paymentProcessor.processPayment(productName, totalCost)) {
                    inventoryManager.updateInventory(productName);
                    shippingService.shipProduct(productName);
                    System.out.println("Order completed for " + productName + ". Total cost: $" + totalCost);
                } else {
                    System.out.println("Payment failed for " + productName);
                }
            } else {
                System.out.println(productName + " is out of stock.");
            }
        } else {
            System.out.println("Product " + productName + " not found.");
        }
    }
}
