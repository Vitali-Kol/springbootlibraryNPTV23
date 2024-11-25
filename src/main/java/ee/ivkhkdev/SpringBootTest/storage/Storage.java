package ee.ivkhkdev.SpringBootTest.storage;

import ee.ivkhkdev.SpringBootTest.interfaces.AppRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Storage<T> implements AppRepository<T> {
}
