package ee.ivkhkdev.SpringBootTest.input;

import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
