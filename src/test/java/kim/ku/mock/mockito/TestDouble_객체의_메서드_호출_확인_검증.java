package kim.ku.mock.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * 아래 예 말고도 timeout, 중간 mock 해제 등 다양한 옵션이 많다. 아래 참고
 * https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
 */
@ExtendWith(MockitoExtension.class)
class TestDouble_객체의_메서드_호출_확인_검증 {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @InjectMocks
    StudyService studyService;

    @Test
    void 메서드_호출_개수_확인_verify() {
        when(studyRepository.findByStudyId("Math"))
                .thenReturn(Optional.ofNullable(new Study()));

        studyService.findStudy("Math");

        verify(studyRepository, times(1)).findByStudyId("Math");
    }

    @Test
    void 메서드들의_3번_호출_0번_호출_verify() {
        when(studyRepository.findByStudyId(any()))
                .thenReturn(Optional.ofNullable(new Study()))
                .thenReturn(Optional.ofNullable(new Study()))
                .thenReturn(Optional.ofNullable(new Study()));

        studyService.findStudy("Math");
        studyService.findStudy("English");
        studyService.findStudy(any());

        verify(studyRepository, times(3)).findByStudyId(any());
        verify(studyRepository, never()).validate(any());
    }

    @Test
    void 메서드들의_호출_순서_verify() {
        when(studyRepository.findByStudyId(any()))
                .thenReturn(Optional.ofNullable(new Study()));
        doNothing().when(studyRepository).notify(any()); // void 메서드 실행 시, 사실 void는 when 할 필요가 없는게 void이기 때문이지만
        // https://stacktraceguru.com/unittest/mock-void-method

        studyService.findStudy(any());

        InOrder inOrder = inOrder(studyRepository);
        inOrder.verify(studyRepository).findByStudyId(any());
        inOrder.verify(studyRepository).notify(any());
    }
}
