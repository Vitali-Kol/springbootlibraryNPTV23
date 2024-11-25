package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.User;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements AppService {

    private final AppHelper<User> userAppHelper;

    @Autowired
    public UserService(AppHelper<User> userAppHelper) {
        this.userAppHelper = userAppHelper;
    }

    @Override
    public boolean add() {
        Optional<User> user = userAppHelper.create();
        if (user.isPresent()) {
            System.out.println("Пользователь добавлен:\n" + user.get());
            return true;
        }
        return false;
    }
}