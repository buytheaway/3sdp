public class Testing {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        shoppingFacade.placeOrder("Laptop", 999.99);
        shoppingFacade.placeOrder("Phone", 599.99);
        shoppingFacade.placeOrder("Smartwatch", 299.99);
    }
}
