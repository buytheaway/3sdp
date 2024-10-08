import java.util.HashMap;
import java.util.Map;

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

class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void placeOrder(String productName, double paymentAmount) {
        System.out.println("Starting order process for " + productName + "...");

        String product = String.valueOf(productCatalog.searchProduct(productName));

        if (inventoryManager.checkStock(product)) {
            double shippingCost = shippingService.calculateShipping(product);
            double totalCost = paymentAmount + shippingCost;

            if (paymentProcessor.processPayment(product, totalCost)) {
                inventoryManager.updateInventory(product);
                shippingService.shipProduct(product);
                System.out.println("Order completed for " + product + ". Total cost: $" + totalCost);
            } else {
                System.out.println("Payment failed for " + product);
            }
        } else {
            System.out.println(product + " is out of stock.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Facade shoppingFacade = new Facade();
        shoppingFacade.placeOrder("Laptop", 999.99);
    }
}
