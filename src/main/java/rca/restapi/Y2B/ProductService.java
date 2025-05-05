package rca.restapi.Y2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public void createProduct(Product product) {
        repository.save(product);
    }

    public Optional<Product> getProduct(Long prodId) {
        return repository.findById(prodId);
    }
}
