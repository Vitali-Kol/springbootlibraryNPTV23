package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.User;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements AppService {

    private final AppHelper<User> userAppHelper;
    private final List<User> userList = new ArrayList<>(); // Локальное хранилище пользователей

    @Autowired
    public UserService(AppHelper<User> userAppHelper) {
        this.userAppHelper = userAppHelper;
    }

    @Override
    public boolean add() {
        Optional<User> user = userAppHelper.create();
        if (user.isPresent()) {
            userList.add(user.get()); // Сохраняем пользователя в список
            System.out.println("Пользователь успешно добавлен:\n" + user.get());
            return true;
        }
        System.out.println("Не удалось добавить пользователя.");
        return false;
    }

    // Метод для вывода всех пользователей
    public void listAllUsers() {
        if (userList.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список всех пользователей:");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}
