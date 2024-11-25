package ee.ivkhkdev.SpringBootTest.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository<T> extends JpaRepository<T, Long> {

}
