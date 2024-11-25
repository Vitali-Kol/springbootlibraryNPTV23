package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.Product;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements AppService {

    private final AppHelper<Product> productAppHelper;

    @Autowired
    public ProductService(AppHelper<Product> productAppHelper) {
        this.productAppHelper = productAppHelper;
    }

    @Override
    public boolean add() {
        // Создаём продукт через AppHelper
        Optional<Product> product = productAppHelper.create();

        // Проверяем, создан ли продукт
        if (product.isPresent()) {
            System.out.println("Продукт успешно добавлен:\n" + product.get());
            return true;
        } else {
            System.out.println("Не удалось добавить продукт.");
            return false;
        }
    }
}
