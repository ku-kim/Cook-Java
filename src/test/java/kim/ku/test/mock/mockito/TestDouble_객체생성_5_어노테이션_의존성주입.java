package kim.ku.test.mock.mockito;

import kim.ku.test.mock.mockito.MemberService;
import kim.ku.test.mock.mockito.StudyRepository;
import kim.ku.test.mock.mockito.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StudyService 객체를 만들 때
 * 아직 구현되지 않은 StudyRepository, MemberService 를 Mock으로 대체하는 방법
 *
 * @ExtendWith() + @Mock + InjectMocks
 * StudyService는 StudyRepository, MemberService주입이 필요하지만 @InjectMock를 통해
 * 자동 의존성 주입까지 가능
 */
@DisplayName("Mock 객체 만들기 - 어노테이션2")
@ExtendWith(MockitoExtension.class)
class TestDouble_객체생성_5_어노테이션_의존성주입 {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @InjectMocks
    StudyService studyService;

    @Test
    void 어노테이션_ExtendWith_Mock_InjdectionMocks() {
        assertThat(studyService).isNotNull();
    }
}
