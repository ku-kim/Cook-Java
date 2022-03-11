package kim.ku.test.mock.mockito;

import java.util.Optional;

public interface MemberService {

    Optional<Member> save(Member member);
}
