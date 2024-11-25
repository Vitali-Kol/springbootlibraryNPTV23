package ee.ivkhkdev.SpringBootTest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация ID
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // Конструктор по умолчанию
    public User() {
    }

    // Конструктор с параметрами
    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "Пользователь: \n" +
                "ID: " + id + "\n" +
                "Имя: " + firstName + "\n" +
                "Фамилия: " + lastName + "\n" +
                "Email: " + email + "\n";
    }
}
