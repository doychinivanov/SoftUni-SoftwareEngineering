package com.json.processing.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.processing.entities.categories.Category;
import com.json.processing.entities.categories.CategoryImportDTO;
import com.json.processing.entities.products.Product;
import com.json.processing.entities.products.ProductImportDTO;
import com.json.processing.entities.users.User;
import com.json.processing.entities.users.UserImportDTO;
import com.json.processing.repositories.CategoryRepository;
import com.json.processing.repositories.ProductRepository;
import com.json.processing.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService{

    private static final Path USERS_JSON_PATH = Path.of("src", "main", "resources", "users.json");
    private static final Path CATEGORIES_JSON_PATH = Path.of("src", "main", "resources", "categories.json");
    private static final Path PRODUCTS_JSON_PATH = Path.of("src", "main", "resources", "products.json");

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modalMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.modalMapper = new ModelMapper();
        this.gson = new Gson();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(USERS_JSON_PATH.toAbsolutePath().toString());

        UserImportDTO[] userImportDTOS = this.gson.fromJson(fileReader, UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS)
                .map(importDto -> this.modalMapper.map(importDto, User.class))
                .toList();

        this.userRepository.saveAll(users);

    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toAbsolutePath().toString());

        CategoryImportDTO[] categoryImportDTOS = this.gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categories = Arrays.stream(categoryImportDTOS)
                .map(categoryDto -> modalMapper.map(categoryDto, Category.class))
                .toList();

        this.categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toAbsolutePath().toString());
        ProductImportDTO[] productImportDTOS = gson.fromJson(fileReader, ProductImportDTO[].class);

        List<Product> products = Arrays.stream(productImportDTOS)
                .map(productImportDTO -> modalMapper.map(productImportDTO, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories)
                .toList();

        this.productRepository.saveAll(products);

    }

    private Product setRandomCategories(Product product) {
        Random random = new Random();
        long categoriesInDb = this.categoryRepository.count();
        int count  = random.nextInt((int) categoriesInDb);

        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < count ; i++) {
            int randomId = random.nextInt((int) categoriesInDb) + 1;

            Optional<Category> randomCategory = this.categoryRepository.findById(randomId);

            categories.add(randomCategory.get());
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if(product.getPrice().compareTo(BigDecimal.valueOf(944)) > 0) return product;

        Optional<User> randomUser = getRandomUser();

        product.setBuyer(randomUser.get());
        return product;
    }

    private Product setRandomSeller(Product product) {
        Optional<User> randomUser = getRandomUser();

        product.setSeller(randomUser.get());
        return product;
    }

    private Optional<User> getRandomUser() {
        long usersCount = this.userRepository.count();

        int randomUserId = new Random().nextInt((int) usersCount) + 1;

        return this.userRepository.findById(randomUserId);
    }
}
