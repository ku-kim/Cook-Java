package kim.ku.test.chicagoVSlondon.london;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * 아래 예는 런던파(mockist)의 테스트코드이다.
 * 특징
 * 테스트 대상 단위는 코드, 단일 클래스이다.
 * 불변 의존성을 제외한 모든 의존성 테스트를 대역으로 대체한다.
 *
 * 장점
 * 각 테스트는 해당 테스트 대상 클래스만 대상, 입자성
 * 연결된 클래스의 그래프에 대한 테스트 용이성
 * 테스트 실패 후 버그 있는 기능 쉽게 발견 가능
 *
 * 문제점
 * 테스트가 동작 단위가 아니라 코드 단위, 클래스 단위
 * 각 테스트를 단위테스트할 수 없다는 건 코드 설계 문제점일 수 있음
 * 테스트 대역 사용한다고하면 오히려 문제를 숨길 뿐
 *
 * StoreImpl이 아닌 인터페이스 Store를 Mock 객체로 사용
 * Store의 상태를 수정하는 대신 hasEnoughInventort() 세머드 호출에 대한 리턴만 목에 직접 정의
 * store의 실제 상태와 관계 없이 테스트가 요구하는 방식으로 요청에 응답
 *
 * 검증 단계
 * customer.purchase 호출 결과를 확인하지만, 고객이 상점에서 올바르게 체크했는지 다르다
 * 시카고 학파는 이전 상점 상태를 검증했다면 지금은 Customer - Store간의 상호 작용을 검사한다
 * 즉, 고객이 상점에서 호출을 올바르게 했는지 확인, 심지어 몇 번 호출했는지 까지 확인
 *
 */
class londonTest {

    @Test
    void Purchase_succeeds_when_enough_inventory() {
        // Arrange
        Store storeMock = Mockito.mock(Store.class);
        when(storeMock.hasEnoughInventory(Product.SHAMPOO, 5))
                .thenReturn(true);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(storeMock, Product.SHAMPOO, 5);

        // Assert
        assertThat(success).isTrue();
        verify(storeMock, times(1)).removeInventory(Product.SHAMPOO, 5);
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() {
        // Arrange
        Store storeMock = Mockito.mock(Store.class);
        when(storeMock.hasEnoughInventory(Product.SHAMPOO, 5))
                .thenReturn(false);
        Customer customer = new Customer();

        // Act
        boolean success = customer.purchase(storeMock, Product.SHAMPOO, 5);

        // Assert
        assertThat(success).isFalse();
        verify(storeMock, never()).removeInventory(Product.SHAMPOO, 5);
    }
}
