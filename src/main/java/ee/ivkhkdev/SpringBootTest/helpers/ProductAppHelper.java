package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.entities.Product;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class ProductAppHelper implements AppHelper<Product> {

    @Override
    public Optional<Product> create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID продукта:");
        Long id = Long.parseLong(scanner.nextLine());

        System.out.println("Введите название продукта:");
        String name = scanner.nextLine();

        System.out.println("Введите описание продукта:");
        String description = scanner.nextLine();

        System.out.println("Введите цену продукта:");
        double price = Double.parseDouble(scanner.nextLine());

        // Создаем объект Product
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        System.out.println("Продукт успешно создан:\n" + product);

        return Optional.of(product);
    }
}
