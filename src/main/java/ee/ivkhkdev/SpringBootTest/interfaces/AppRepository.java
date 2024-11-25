package ee.ivkhkdev.SpringBootTest.interfaces;

import java.util.List;

public interface AppRepository<T> {

    default boolean save(T t) {
        List<T> ts = load();
        ts.add(t);
        return saveAll(ts);
    }

    default boolean saveAll(List<T> ts) {
        return true;
    }

    default List<T> load() {
        return List.of();
    }
}
