package kim.ku.test.chicagoVSlondon.london;


public interface Store {
    public boolean hasEnoughInventory(Product product, int quantity);

    public void removeInventory(Product product, int quantity);

    public void addInventory(Product product, int quantity);

    public int getInventory(Product product);
}
