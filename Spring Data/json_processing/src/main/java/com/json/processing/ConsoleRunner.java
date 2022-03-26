package com.json.processing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.processing.entities.categories.CategoryStatDTO;
import com.json.processing.entities.products.Product;
import com.json.processing.entities.products.ProductWithNoBuyerDTO;
import com.json.processing.entities.users.UserWithSoldProductsDTO;
import com.json.processing.services.ProductService;
import com.json.processing.services.SeedService;
import com.json.processing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    private final Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void run(String... args) throws Exception {
        getCategoryStats();
    }

    private void loadDataToDB() throws FileNotFoundException {
        this.seedService.seedAll();
    }

    private void getCategoryStats() {
        List<CategoryStatDTO> categoryStats = this.productService.getCategoryStats();

        String jsonResult = this.gson.toJson(categoryStats);
        System.out.println(jsonResult);
    }

    private void getUsersWithSoldProducts() {
        List<UserWithSoldProductsDTO> usersWithSoldProducts = this.userService.getUsersWithSoldProducts();

        String jsonResult = this.gson.toJson(usersWithSoldProducts);

        System.out.println(jsonResult);
    }

    private void getProductsInPriceRangeAndWithNoBuyer() {
        List<ProductWithNoBuyerDTO> productsWithNoBuyer = this.productService.getProductsWithNoBuyer(500, 1000);

        String json = this.gson.toJson(productsWithNoBuyer);

        System.out.println(json);
    }
}
