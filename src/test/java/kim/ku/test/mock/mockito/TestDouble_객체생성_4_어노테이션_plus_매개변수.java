package kim.ku.test.mock.mockito;

import kim.ku.test.mock.mockito.MemberService;
import kim.ku.test.mock.mockito.StudyRepository;
import kim.ku.test.mock.mockito.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StudyService 객체를 만들 때
 * 아직 구현되지 않은 StudyRepository, MemberService 를 Mock으로 대체하는 방법
 *
 * @ExtendWith() + @Mock 활용하여 Mockito.mock() 과정을 어노테이션으로 대체
 * 테스트 매개변수로 넣어줄 수 있음
 */
@DisplayName("Mock 객체 만들기 - 어노테이션2")
@ExtendWith(MockitoExtension.class)
class TestDouble_객체생성_4_어노테이션_plus_매개변수 {

    @Test
    void 어노테이션_테스트코드에_매개변수로(@Mock StudyRepository studyRepository,
                                         @Mock MemberService memberService) {
        StudyService studyService = new StudyService(studyRepository, memberService);

        assertThat(studyService).isNotNull();
    }
}
