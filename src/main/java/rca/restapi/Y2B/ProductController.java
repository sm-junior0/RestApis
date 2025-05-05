package rca.restapi.Y2B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        service.createProduct(product);
    }
}