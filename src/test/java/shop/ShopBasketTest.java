package shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShopBasketTest {
    @Mock
    private ShopItemRepository shopItemRepository;
    @InjectMocks
    private ShopBasket shopBasket;

    @Test
    void shouldAddItemToBasket() {
        //given
        ShopItem shoes = new ShopItem("shoes", 2.0);
        //when
        shopBasket.addItem(shoes, 1);
        //then
        Assertions.assertThat(shopBasket.contains("shoes")).isTrue();
        Assertions.assertThat(shopBasket.getCountOf(shoes.getUniqueIdentifier())).isEqualTo(1);
    }

    @Test
    void shouldRemoveItemFromBasket() {
        //given
        ShopItem shoes = new ShopItem("shoes", 2.0);
        ShopItem hats = new ShopItem("hats", 2.0);
        shopBasket.addItem(shoes, 1);
        shopBasket.addItem(hats, 1);
        //when
        shopBasket.removeItem(shoes, 1);
        //then
        Assertions.assertThat(shopBasket.contains("shoes")).isFalse();
        Assertions.assertThat(shopBasket.contains("hats")).isTrue();
    }

    @Test
    void shouldReturnTotalPrice() {
        //given
        ShopItem shoes = new ShopItem("shoes", 2.0);
        ShopItem hats = new ShopItem("hats", 2.0);
        //when
        shopBasket.addItem(shoes, 1);
        shopBasket.addItem(hats, 1);
        //then
        Assertions.assertThat(shopBasket.getTotalPrice()).isEqualTo(4);
    }

    @Test
    void shouldReturnResultCountOf() {
        //given
        ShopItem shoes = new ShopItem("shoes", 2.0);
        //when
        shopBasket.addItem(shoes, 1);
        shopBasket.addItem(shoes, 1);
        //then
        Assertions.assertThat(shopBasket.getCountOf(shoes.getUniqueIdentifier())).isEqualTo(2);
    }

    @Test
    void shouldReturnBasketStatusNotEmpty() {
        //given
        ShopItem shoes = new ShopItem("shoes", 2.0);
        //when
        shopBasket.addItem(shoes, 1);
        //then
        Assertions.assertThat(shopBasket.status()).isEqualTo("not empty?");
    }

    @Test
    void shouldReturnBasketStatusEmpty() {
        //then
        Assertions.assertThat(shopBasket.status()).isEqualTo("empty");
    }

    @Test
    void shouldCheckContainsOfBasket() {
        //given
        String hatUniqueID = "hat123";
        double price = 2.0;
        //when
        ShopItem hat123 = new ShopItem(hatUniqueID, price);
        //then
        Assertions.assertThat(hat123.getPrice()).isEqualTo(price);
        Assertions.assertThat(hat123.getUniqueIdentifier()).isEqualTo(hatUniqueID);
    }

    @Test
    void shouldReturnTrueIfItemExistInDB() {
        //given
        String idOfItem = "hat123";
        ShopItem loadedHatFromDB = new ShopItem("sdsa", 23);
        when(shopItemRepository.load(idOfItem)).thenReturn(loadedHatFromDB);
        //when
        boolean result = shopBasket.isExistInDb(idOfItem);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseIfItemNotExistInDB() {
        //given
        String idOfItem = "hat123";
        when(shopItemRepository.load(idOfItem)).thenReturn(null);
        //when
        boolean result = shopBasket.isExistInDb(idOfItem);
        //then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void shouldLoadAllItemsFromDB() {
        //given
        ShopItem itemFromDb = new ShopItem("hat123", 1.0);
        ArrayList<ShopItem> shopItemsFromDB = new ArrayList<>();
        shopItemsFromDB.add(itemFromDb);
        when(shopItemRepository.loadAll()).thenReturn(shopItemsFromDB);
        //when
        shopBasket.loadItemsFromDb();
        //then
        Assertions.assertThat(shopBasket.contains("hat123")).isTrue();
    }
}