package service;


import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDaoImpl productDao = ProductDaoImpl.getInstance();

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
    public boolean isProductOnWarehouse(String name) {
        try {
            for(Product product : getAllProducts()) {
                if (isProductByNameAvailable(name) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductByNameAvailable(String name) {
        Product product = null;
        try {
            product = instanceProductService.getProductByName(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isProductByIdAvailable(Long id) {
        Product product = null;
        try {
            product = getProductById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean saveProduct(Product product) {
        return false;
    }
}
