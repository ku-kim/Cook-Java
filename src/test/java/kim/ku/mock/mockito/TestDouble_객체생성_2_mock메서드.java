package kim.ku.mock.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StudyService 객체를 만들 때
 * 아직 구현되지 않은 StudyRepository, MemberService 를 Mock으로 대체하는 방법
 */
@DisplayName("Mock 객체 만들기")
class TestDouble_객체생성_2_mock메서드 {

    private StudyService studyService;

    private StudyRepository studyRepository;
    private MemberService memberService;

    @Test
    @DisplayName("Mockito.mock() mock 객체 사용")
    void create_mock_object_studyService() {
        studyRepository = Mockito.mock(StudyRepository.class);
        memberService = Mockito.mock(MemberService.class);

        studyService = new StudyService(studyRepository, memberService);

        assertThat(studyService).isNotNull();
    }
}