package uz.mybux.cash.product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<ProductResponse> ProductList(Long tin);
}
