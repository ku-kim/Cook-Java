package kim.ku.test.mock.mockito;

import kim.ku.test.mock.mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * StudyService 객체를 만들 때
 * 아직 구현되지 않은 StudyRepository, MemberService 를 임시 구현체로 대체하는 방법
 */
class TestDouble_객체생성_1_mock없이 {

    private StudyService studyService;

    private StudyRepository studyRepository;
    private MemberService memberService;

    @Test
    @DisplayName("직접만들기")
    void 직접만들기() {
        studyRepository = new StudyRepository() {
            @Override
            public Optional<Study> findByStudyId(String id) {
                throw new UnsupportedOperationException("#findByStudyId 아직 구현하지 않음 !!");
            }

            @Override
            public void validate(String id) {
                throw new UnsupportedOperationException("#validate 아직 구현하지 않음 !!");

            }

            @Override
            public void notify(String id) {
                throw new UnsupportedOperationException("#notify 아직 구현하지 않음 !!");

            }

            @Override
            public String toString() {
                return super.toString();
            }
        };

        memberService = new MemberService() {
            @Override
            public Optional<Member> save(Member member) {
                throw new UnsupportedOperationException("#save 아직 구현하지 않음 !!");

            }
        };

        studyService = new StudyService(studyRepository, memberService);

        assertThat(studyService).isNotNull();
    }

}
