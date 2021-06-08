package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {
    private ProductService productService = ProductServiceImpl.getInstance();

    //Singleton
    private static ProductFacadeImpl instanceProductFacadeImpl = null;

    public static ProductFacadeImpl getInstance() {
        if (instanceProductFacadeImpl == null) {
            instanceProductFacadeImpl = new ProductFacadeImpl();
        }
        return instanceProductFacadeImpl;
    }

    @Override
    public String createProduct(Product product) {
        try {
            productService.saveProduct(product);
            return "Product saved successfully";
        } catch (ProductPriceNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductNameEmptyException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductCountNegativeException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductWeightNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String removeProduct(String productName) {
        try {
            productService.removeProduct(productName);
            return "Product removed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return Collections.emptyList();
    }
}
