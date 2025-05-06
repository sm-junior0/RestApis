package rca.restapi.Y2B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProductsWithoutPagination() {
        return repository.findAll();
    }

    public Page<Product> getAllProducts(int page, int size, String sortBy, String direction) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        return repository.findAll(pageable);
    }

    public Page<Product> getAllProductsWithNativePagination(int page, int size, String sortBy, String direction) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllWithPaginationNative(sortBy, direction, pageable);
    }

    public List<Product> findProductsByName(String name) {
        return repository.findProductsByNameNative(name);
    }

    public List<Product> findProductsByPriceGreaterThan(int minPrice) {
        return repository.findProductsByPriceGreaterThanNative(minPrice);
    }

    public void createProduct(Product product) {
        repository.save(product);
    }

    public Optional<Product> getProduct(Long prodId) {
        return repository.findById(prodId);
    }

    public void updateProduct(Long prodId, Product updatedProduct) {
        if (repository.existsById(prodId)) {
            updatedProduct.setProductId(prodId);
            repository.save(updatedProduct);
        }
    }

    public void deleteProduct(Long prodId) {
        repository.deleteById(prodId);
    }
}
