package dao;

import api.ProductDao;
import entity.Product;
import entity.parse.ProductParser;
/*import utils.FileUtils;*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    private final String fileName = "products.data";


/*    private ProductDaoImpl(){

        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    static ProductDaoImpl instanceProductDaoImpl;

    public static ProductDaoImpl getInstance() {
        if(instanceProductDaoImpl == null){
            instanceProductDaoImpl = new ProductDaoImpl();
        }
        return instanceProductDaoImpl;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> listOfAllProducts = getAllProducts();
        listOfAllProducts.add(product);
        saveProductList(listOfAllProducts);
    }

    @Override
    public void saveProductList(List<Product> products) throws IOException {
        new FileWriter(fileName, false).close();
        FileWriter fileWriter = new FileWriter(fileName, true);


        for (Product loopProduct : products) {
            fileWriter.write(loopProduct.toString());
        }
        fileWriter.close();
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> listOfAllProducts = getAllProducts();

        for (Product loopProduct : listOfAllProducts) {
            if (loopProduct.getProductID().equals(productId)) {
                listOfAllProducts.remove(loopProduct);
            }
        }
        saveProductList(listOfAllProducts);
    }


    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> listOfAllProducts = getAllProducts();

        for (Product loopProduct : listOfAllProducts) {
            if (loopProduct.getProductName().equals(productName)) {
                listOfAllProducts.remove(loopProduct);
            }
        }
        saveProductList(listOfAllProducts);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> listOfAllProducts = new ArrayList<Product>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String readProductLine = null;
        while ((readProductLine = reader.readLine()) != null) {
            Product readProduct = ProductParser.stringToProduct(readProductLine);
            if (readProduct != null) {
                listOfAllProducts.add(readProduct);
            }

        }
        reader.close();
        return listOfAllProducts;
    }

}
