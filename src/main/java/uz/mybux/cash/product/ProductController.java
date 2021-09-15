package uz.mybux.cash.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.mybux.cash.users.AuthUser;
import uz.mybux.cash.users.AuthUserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Tag(name="Товары и услуги",description="Настройки товаров")
@RestController
@RequestMapping(value = "/product/")
@Validated
@Configuration
public class ProductController {
    ProductService productService;
    AuthUserService authUserService;
    @Autowired
    public ProductController(ProductService productService,AuthUserService authUserService){
        this.productService=productService;
        this.authUserService=authUserService;
    }
    @Operation(security = @SecurityRequirement(name = "bearerAuth"),summary = "Добавить товары")
    @PostMapping("add")
    public ResponseEntity add(Principal principal, @RequestBody ProductDto productDto){
        Product product = new Product();
        product.setGroupId(productDto.groupId);
        product.setName(productDto.ProductName);
        product.setBarCode(productDto.barcode);
        product.setDiscount(productDto.discount);
        product.setPrice(productDto.price);
        product.setVat(productDto.vat);
        product.setProductType(productDto.productType);
        product.setLabel(productDto.label);
        Optional<AuthUser> user =authUserService.loadByUserName(principal.getName());
        if(user.isPresent()){
            product.setTin(user.get().getTin());
            product.setUser_id(user.get().getId());
            productService.addProduct(product);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @Operation(security = @SecurityRequirement(name = "bearerAuth"),summary = "Список товары")
    @GetMapping("list")
    public ResponseEntity list(Principal principal){
        Optional<AuthUser> user =authUserService.loadByUserName(principal.getName());
        if(user.isPresent()) {
            List<ProductResponse> productList = productService.ProductList(user.get().getTin());
            return new ResponseEntity(productList,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
