package kim.ku.mock.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * StudyService 객체를 만들 때
 * 아직 구현되지 않은 StudyRepository, MemberService 를 Mock으로 대체하는 방법
 * @ExtendWith() + @Mock 활용하여 Mockito.mock() 과정을 어노테이션으로 대체
 */
@DisplayName("Mock 객체 만들기 - 어노테이션1")
@ExtendWith(MockitoExtension.class)
class TestDouble_객체생성_3_어노테이션 {

    @Mock
    private StudyRepository studyRepository;
    @Mock
    private MemberService memberService;

    @Test
    @DisplayName("어노테이션 사용")
    void 어노테이션사용() {
        StudyService studyService = new StudyService(studyRepository, memberService);

        assertThat(studyService).isNotNull();
    }
}