package kim.ku.mock.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BDDStyleAPI {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @InjectMocks
    StudyService studyService;

    @Test
    void BDD_Style() {
        // given
        given(studyRepository.findByStudyId(any()))
                .willReturn(Optional.ofNullable(new Study()));

        // when
        studyService.findStudy("Math");

        // then
        then(studyRepository).should(times(1)).findByStudyId(any());

    }

    @Test
    void when_verify() {
        when(studyRepository.findByStudyId("Math"))
                .thenReturn(Optional.ofNullable(new Study()));

        studyService.findStudy("Math");

        then(studyRepository).should(times(1)).findByStudyId(any());
        verify(studyRepository, times(1)).findByStudyId("Math");
    }

}
