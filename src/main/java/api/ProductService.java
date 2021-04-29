package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;

    Integer getProductsCount() throws IOException;
    Product getProductByName(String name) throws IOException;

    boolean isProductOnWarehouse (String name);
    boolean isProductByNameAvailable (String name);
    boolean isProductByIdAvailable (Long id);

    boolean saveProduct (Product product);

}
