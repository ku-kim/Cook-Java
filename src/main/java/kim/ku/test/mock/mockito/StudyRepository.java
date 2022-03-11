package kim.ku.test.mock.mockito;

import java.util.Optional;

public interface StudyRepository {
    Optional<Study> findByStudyId(String id);

    void validate(String id);

    void notify(String id);
}
