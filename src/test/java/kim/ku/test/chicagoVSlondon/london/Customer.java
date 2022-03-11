package kim.ku.test.chicagoVSlondon.london;

import kim.ku.test.chicagoVSlondon.london.Product;
import kim.ku.test.chicagoVSlondon.london.Store;

/**
 * 책 단위 테스트의 C# 코드 -> Java 변경
 * https://github.com/AcornPublishing/unit-testing/blob/main/Book/Chapter2/Listing1/Other.cs
 */
public class Customer {
    public boolean purchase(Store store, Product product, int quantity) {
        if (!store.hasEnoughInventory(product, quantity)) {
            return false;
        }
        store.removeInventory(product, quantity);
        return true;
    }
}
