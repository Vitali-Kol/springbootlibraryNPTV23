package ee.ivkhkdev.SpringBootTest;

import ee.ivkhkdev.SpringBootTest.services.UserService;
import ee.ivkhkdev.SpringBootTest.services.ProductService;
import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication implements CommandLineRunner {

	private final Input input;
	private final UserService userService;
	private final ProductService productService;

	// Конструктор с внедрением зависимостей
	public SpringBootTestApplication(Input input, UserService userService, ProductService productService) {
		this.input = input;
		this.userService = userService;
		this.productService = productService;
	}

	@Override
	public void run(String... args) throws Exception {
		boolean repeat = true;
		do {
			System.out.println("Список задач:");
			System.out.println("0. Выход");
			System.out.println("1. Добавить пользователя");
			System.out.println("2. Добавить продукт");
			System.out.println("3. Показать всех пользователей");
			System.out.println("4. Показать все продукты");
			System.out.println("Выберите задачу из списка:");

			try {
				int task = Integer.parseInt(input.nextLine().trim());

				switch (task) {
					case 0:
						repeat = false;
						break;
					case 1:
						if (userService.add()) {
							System.out.println("Пользователь добавлен.");
						} else {
							System.out.println("Пользователя добавить не удалось.");
						}
						break;

					case 2:
						if (productService.add()) {
							System.out.println("Продукт добавлен.");
						} else {
							System.out.println("Продукт добавить не удалось.");
						}
						break;

					case 3:
						userService.listAllUsers(); // Показать всех пользователей
						break;

					case 4:
						productService.listAllProducts(); // Показать все продукты
						break;

					default:
						System.out.println("Выбрана задача не из списка!");
						break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Ошибка ввода! Введите номер задачи из списка.");
			}
		} while (repeat);

		System.out.println("До свидания!");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
