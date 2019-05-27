package shop;

import java.util.ArrayList;

public class ShopBasket {

    private ArrayList<ShopItem> items = new ArrayList<>();
    private ShopItemRepository shopItemRepository = new ShopItemRepository();

    public void addItem(ShopItem item, int count) {
        while (count > 0) {
            items.add(item);
            count--;
        }
    }

    public void removeItem(ShopItem item, int count) {
        while (count > 0) {
            items.remove(item);
            count--;
        }
    }

    public double getTotalPrice() {
        return items
                .stream()
                .mapToDouble(ShopItem::getPrice)
                .sum();
    }

    public double getCountOf(String itemUniqueIdentifier) {
        int resultCount = 0;
        for (ShopItem itemFromBasket: items) {
            if(itemFromBasket.getUniqueIdentifier().equals(itemUniqueIdentifier)) {
                resultCount++;
            }
        }
        return resultCount;
    }

    public boolean contains(String itemUniqueIdentifier) {
        return items
                .stream()
                .anyMatch(item -> item.getUniqueIdentifier().equals(itemUniqueIdentifier));

    }

    public String status() {
        if (items.isEmpty())
        {
            return "empty";
        }
        return "not empty?";
    }

    public boolean isExistitInDb(String uniqueIdentifier){
        return shopItemRepository.load(uniqueIdentifier) != null;
    }

    public void store(){
        shopItemRepository.store(items);
    }

    public void loadItemsFromDb(){
        this.items = this.shopItemRepository.loadAll();
    }
}
