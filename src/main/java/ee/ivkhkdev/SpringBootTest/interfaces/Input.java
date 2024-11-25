package ee.ivkhkdev.SpringBootTest.interfaces;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public interface Input {
    default String nextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
