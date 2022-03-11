package kim.ku.test.chicagoVSlondon.chicago;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 아래 예는 클래식 학파(시카고)의 테스트 코드이다.
 * 특징으로 단위 테스트간 분리되어 있다
 * 테스트 대상 단위는 코드 단위가 아니라 동작 단위다.
 *
 * 이 경우 고객이 SUT(System Under Test)이고 상점(Store)이 협력자이다.
 * 협력자가 필요한 이유
 * 테스트 대상 메서드 실행하려면 customer.purchase() -> Store 인스턴스가 필요하다
 * 검증 단계에서 customer.purchase() 결과 중 하나로 상점 제품 수량이 감소할 가능성이 있기 때문에 필요하다.
 *
 * Customer + Store 둘 다 검증한다. 그러나 Customer가 올바르게 작동하더라도 Store 내부 버그가 있다면 단위 테스트에 실패한다.
 * 두 클래스는 격리돼 있지 않다.
 * 책 단위 테스트의 C# 코드 -> Java 변경
 * https://github.com/AcornPublishing/unit-testing/blob/main/Book/Chapter2/Listing1/CustomerTests.cs
 *
 */
class ChicagoTest {

    @Test
    void Purchase_succeeds_when_enough_inventory() {
        // Arrange
        Store store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(store, Product.SHAMPOO, 5);

        // Assert
        assertThat(success).isTrue();
        assertThat(store.getInventory(Product.SHAMPOO)).isEqualTo(5);
    }


    @Test
    void Purchase_fails_when_not_enough_inventory() {
        // Arrange
        Store store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(store, Product.SHAMPOO, 15);

        // Assert
        assertThat(success).isFalse();
        assertThat(store.getInventory(Product.SHAMPOO)).isEqualTo(10);
    }
}
