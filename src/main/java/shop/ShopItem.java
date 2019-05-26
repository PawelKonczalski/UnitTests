package shop;


public class ShopItem {

    private String uniqueIdentifier;

    private double price;

    public ShopItem(String uniqueIdentifier, double price) {
        this.uniqueIdentifier = uniqueIdentifier;
        this.price = price;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public double getPrice() {
        return price;
    }


}
