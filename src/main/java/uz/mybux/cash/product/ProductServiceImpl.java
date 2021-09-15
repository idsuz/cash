package uz.mybux.cash.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.mybux.cash.config.Status;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    ProductRepository repository;
    ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }
    @Override
    public void addProduct(Product product) {
        repository.save(product);
    }

    @Override
    public List<ProductResponse> ProductList(Long tin) {
        return repository.findByTinAndStatus(tin, Status.ACTIVE);
    }
}
