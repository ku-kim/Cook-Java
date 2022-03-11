package kim.ku.mock.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 모든 Mockito의 객체의 메소드의 리턴은 다음과 같다
 * Object : Null
 * Optional : Optional.empty
 * Primitive type : default value  e.g. int : 0
 * Collection : 비어있는 콜렉션
 * void : 아무 일도 발생 X
 */

@DisplayName("Stub_ex_object 객체를 mock으로 사용할 때 메서드들의 기본 리턴값 확인")
@ExtendWith(MockitoExtension.class)
class Stub_기본값 {

    @Mock
    StubExObject stubExObject;

    @Test
    void mock객체_메서드리턴_기본값확인() {
        assertThat(stubExObject.testInt()).isEqualTo(0);
        assertThat(stubExObject.testFloat()).isEqualTo(0.f);
        assertThat(stubExObject.testList()).isEqualTo(List.of());
        assertThat(stubExObject.testObject()).isEqualTo(null);
        assertThat(stubExObject.testOptional()).isEqualTo(Optional.empty());
    }

}
