package rca.restapi.Y2B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<Product> getAllProductsWithoutPagination() {
        return service.getAllProductsWithoutPagination();
    }


    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return service.getAllProducts(page, size, sortBy, direction);
    }

    @GetMapping("/native")
    public Page<Product> getAllProductsWithNativePagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "productId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return service.getAllProductsWithNativePagination(page, size, sortBy, direction);
    }

    @GetMapping("/search/name")
    public List<Product> findProductsByName(@RequestParam String name) {
        return service.findProductsByName(name);
    }

    @GetMapping("/search/price")
    public List<Product> findProductsByPriceGreaterThan(@RequestParam int minPrice) {
        return service.findProductsByPriceGreaterThan(minPrice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = service.getProduct(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        service.createProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        service.updateProduct(id, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}