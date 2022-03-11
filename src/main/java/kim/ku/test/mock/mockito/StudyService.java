package kim.ku.test.mock.mockito;

public class StudyService {

    private final StudyRepository studyRepository;
    private final MemberService memberService;

    public StudyService(StudyRepository studyRepository, MemberService memberService) {
        assert studyRepository != null;
        assert memberService != null;

        this.studyRepository = studyRepository;
        this.memberService = memberService;
    }

    Study findStudy(String id) {
        Study study = studyRepository.findByStudyId(id).orElse(new Study());
        studyRepository.notify(id);
        return study;
    }
}
