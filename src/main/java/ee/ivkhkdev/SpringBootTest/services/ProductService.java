package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.Product;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements AppService {

    private final AppHelper<Product> productAppHelper;

    // Хранилище товаров
    private final List<Product> productList = new ArrayList<>();

    @Autowired
    public ProductService(AppHelper<Product> productAppHelper) {
        this.productAppHelper = productAppHelper;
    }

    @Override
    public boolean add() {
        // Создаём продукт через AppHelper
        Optional<Product> product = productAppHelper.create();

        // Если продукт успешно создан, добавляем его в список
        if (product.isPresent()) {
            productList.add(product.get());
            System.out.println("Продукт успешно добавлен:\n" + product.get());
            return true;
        } else {
            System.out.println("Не удалось добавить продукт.");
            return false;
        }
    }

    // Метод для вывода списка всех товаров
    public void listAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("Список товаров пуст.");
        } else {
            System.out.println("Список всех товаров:");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
}
