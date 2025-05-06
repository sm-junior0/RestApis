package rca.restapi.Y2B;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE prod_name LIKE %:name%", nativeQuery = true)
    List<Product> findProductsByNameNative(@Param("name") String name);

    @Query(value = "SELECT * FROM product WHERE price > :minPrice", nativeQuery = true)
    List<Product> findProductsByPriceGreaterThanNative(@Param("minPrice") int minPrice);

    Page<Product> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM product ORDER BY :sortBy :direction",
           countQuery = "SELECT COUNT(*) FROM product",
           nativeQuery = true)
    Page<Product> findAllWithPaginationNative(
            @Param("sortBy") String sortBy,
            @Param("direction") String direction,
            Pageable pageable);
}