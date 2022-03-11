package kim.ku.test.chicagoVSlondon.chicago;

import java.util.HashMap;

/**
 * 책 단위 테스트의 C# 코드 -> Java 변경
 * https://github.com/AcornPublishing/unit-testing/blob/main/Book/Chapter2/Listing1/Other.cs
 */
public class Store {
    private final HashMap<Product, Integer> inventory = new HashMap();

    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) >= quantity;
    }

    public void removeInventory(Product product, int quantity) {
        if (!hasEnoughInventory(product, quantity)) {
            throw new IllegalStateException("Not enough inventory");
        }
        inventory.put(product, inventory.get(product) - quantity);
    }

    public void addInventory(Product product, int quantity) {
        if (inventory.containsKey(product)) {
            inventory.put(product, inventory.get(product) + quantity);
        }
        inventory.put(product, quantity);
    }

    public int getInventory(Product product) {
        Integer productValue = inventory.get(product);
        if (productValue == 0) {
            return 0;
        }
        return productValue;
    }
}
