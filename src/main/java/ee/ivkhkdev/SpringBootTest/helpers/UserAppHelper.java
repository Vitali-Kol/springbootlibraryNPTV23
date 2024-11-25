package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.entities.User;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class UserAppHelper implements AppHelper<User> {

    @Override
    public Optional<User> create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID пользователя:");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("Введите имя пользователя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию пользователя:");
        String lastName = scanner.nextLine();

        System.out.println("Введите email пользователя:");
        String email = scanner.nextLine();

        // Создаем объект User
        User user = new User(id, firstName, lastName, email);

        System.out.println("Пользователь успешно создан:\n" + user);

        return Optional.of(user);
    }
}
