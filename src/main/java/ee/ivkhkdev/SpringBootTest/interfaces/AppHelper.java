package ee.ivkhkdev.SpringBootTest.interfaces;

import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create();
}
