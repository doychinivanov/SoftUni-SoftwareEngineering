package com.json.processing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.processing.entities.products.ProductWithNoBuyerDTO;
import com.json.processing.services.ProductService;
import com.json.processing.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService) {
        this.seedService = seedService;
        this.productService = productService;

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void run(String... args) throws Exception {
        getProductsInPriceRangeAndWithNoBuyer();
    }

    private void loadDataToDB() throws FileNotFoundException {
        this.seedService.seedAll();
    }

    private void getProductsInPriceRangeAndWithNoBuyer() {
        List<ProductWithNoBuyerDTO> productsWithNoBuyer = this.productService.getProductsWithNoBuyer(500, 1000);

        String json = this.gson.toJson(productsWithNoBuyer);

        System.out.println(json);
    }
}
