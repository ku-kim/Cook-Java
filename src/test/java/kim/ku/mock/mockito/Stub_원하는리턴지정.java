package kim.ku.mock.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#2
 */
@ExtendWith(MockitoExtension.class)
class Stub_원하는리턴지정 {

    @Mock
    StubExObject stubExObject;

    @Test
    void 단순_when_then_return() {
        when(stubExObject.testInt())
                .thenReturn(10);

        assertThat(stubExObject.testInt()).isEqualTo(10);
    }

    @Test
    @DisplayName("when 메서드의 willReturn 순서대로 리턴됨")
    void 여러번_when_then_return() {
        when(stubExObject.testInt())
                .thenReturn(10)
                .thenReturn(20)
                .thenReturn(30);

        assertThat(stubExObject.testInt()).isEqualTo(10);
        assertThat(stubExObject.testInt()).isEqualTo(20);
        assertThat(stubExObject.testInt()).isEqualTo(30);
    }

    @Test
    @DisplayName("예외 던지기도 가능")
    void when_then_throw() {
        when(stubExObject.testInt())
                .thenReturn(10)
                .thenThrow(new IllegalArgumentException());

        assertThat(stubExObject.testInt()).isEqualTo(10);
        assertThatThrownBy(() -> stubExObject.testInt()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("매개변수 있는 메서드, 특정 매개변수에 따른 리턴")
    void when_파라미터() {

        when(stubExObject.testAdd(1, 1))
                .thenReturn(2);

        assertThat(stubExObject.testAdd(1, 1)).isEqualTo(2);
    }

    @Test
    @DisplayName("매개변수 있는 메서드, 매개변수 상관없이 모든 경우, 리턴")
    void when_any_then_xxx() {

        // anyInt() , any() ...
        when(stubExObject.testAdd(anyInt(), anyInt()))
                .thenReturn(200);

        assertThat(stubExObject.testAdd(1, 1)).isEqualTo(200);
        assertThat(stubExObject.testAdd(100, 200)).isEqualTo(200);
        assertThat(stubExObject.testAdd(1, -4)).isEqualTo(200);
    }
}
