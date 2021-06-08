package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDaoImpl productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();

    //Singleton
    private static ProductServiceImpl instanceProductService = null;

    public static ProductServiceImpl getInstance() {
        if (instanceProductService == null) {
            instanceProductService = new ProductServiceImpl();
        }
        return instanceProductService;
    }

    private ProductServiceImpl() {

    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public Integer getProductsCount() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByName(String name) throws IOException {
        return instanceProductService.getProductByName(name);
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products
        ) {
            boolean isFoundProduct = product.getProductID().equals(productId);
            if (isFoundProduct) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String name) throws IOException {

        for (Product product : getAllProducts()) {
            if (isProductByNameAvailable(name) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductByNameAvailable(String name) throws IOException {
        Product product = instanceProductService.getProductByName(name);

        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductByIdAvailable(Long id) throws IOException {
        Product product = getProductById(id);

        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveProduct(Product product) throws ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException, IOException {

            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }

        return false;
    }
}
