package uz.mybux.cash.product;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.mybux.cash.config.Status;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<ProductResponse> findByTinAndStatus(Long tin, Status status);
}
