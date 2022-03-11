package kim.ku.test.chicagoVSlondon.london;

import kim.ku.test.chicagoVSlondon.london.Product;

import java.util.HashMap;

public class StoreImpl implements Store{

    private final HashMap<Product, Integer> inventory = new HashMap();


    @Override
    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) >= quantity;
    }

    @Override
    public void removeInventory(Product product, int quantity) {
        if (!hasEnoughInventory(product, quantity)) {
            throw new IllegalStateException("Not enough inventory");
        }
        inventory.put(product, inventory.get(product) - quantity);
    }

    @Override
    public void addInventory(Product product, int quantity) {
        if (inventory.containsKey(product)) {
            inventory.put(product, inventory.get(product) + quantity);
        }
        inventory.put(product, quantity);
    }

    @Override
    public int getInventory(Product product) {
        Integer productValue = inventory.get(product);
        if (productValue == 0) {
            return 0;
        }
        return productValue;
    }
}
