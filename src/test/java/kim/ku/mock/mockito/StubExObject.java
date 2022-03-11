package kim.ku.mock.mockito;

import java.util.List;
import java.util.Optional;

public interface StubExObject {
    void testVoid();

    int testInt();

    int testAdd(int a, int b);

    float testFloat();

    Object testObject();

    List<Integer> testList();

    Optional<Integer> testOptional();
}
