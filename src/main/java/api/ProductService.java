package api;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;

    Integer getProductsCount() throws IOException;
    Product getProductByName(String name) throws IOException;

    boolean isProductOnWarehouse (String name) throws IOException;
    boolean isProductByNameAvailable (String name) throws IOException;
    boolean isProductByIdAvailable (Long id) throws IOException;

    boolean saveProduct (Product product) throws ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException, IOException;
    void removeProduct(String productName) throws Exception;
}
