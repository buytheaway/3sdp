class Facade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public Facade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void placeOrder(String productName, double paymentAmount) {
        System.out.println("Starting order process for " + productName + "...");

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
