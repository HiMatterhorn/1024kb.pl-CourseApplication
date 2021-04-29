package entity;

import org.junit.Assert;
import org.junit.Test;
import service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

/*    @Test
    public void testGetAllProductsCorrect() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        List<Product> productsFromClass = new ArrayList<Product>();
        productsFromClass = productServiceImplementation.getAllProducts();

        Assert.assertEquals(productsFromClass, productsArray);
    }

    @Test
    public void testGetAllProductsIncorrect() {

        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        List<Product> productsFromClass = productServiceImplementation.getAllProducts();
        productsFromClass.add(new Product(4l, "Gtr", 11, 0.14f, "Blue", 37));

        Assert.assertNotEquals(productsFromClass, productsArray);
    }

    @Test
    public void testGetProductCount() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        int result = productServiceImplementation.getProductsCount();

        Assert.assertEquals(result, productsArray.size());
    }

    @Test
    public void testGetProductCountWhenProductsNotAvailable() {
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl();

        int result = productServiceImplementation.getProductsCount();

        Assert.assertEquals(0, result);
    }


    @Test
    public void testGetProductByName() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));

        Product refProduct = new Product(3l, "Staff", 15, 0.15f, "Black", 27);
        productsArray.add(refProduct);
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Product result = productServiceImplementation.getProductByName("Staff");

        Assert.assertEquals(refProduct, result);
    }

    @Test
    public void testGetProductByNameWhenNotAvailable() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));

        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Product result = productServiceImplementation.getProductByName("Example");

        Assert.assertEquals(null, result);
    }



    @Test
    public void testIsProductByNameCountGreaterThanZero() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Assert.assertTrue(productServiceImplementation.isProductByNameCountGreaterThanZero("Staff"));
    }

    @Test
    public void testIsProductByNameCountGreaterThanZeroWhenListEmpty() {
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl();

        Assert.assertFalse(productServiceImplementation.isProductByNameCountGreaterThanZero("Example"));
    }

    @Test
    public void testIsProductByNameAvailable() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Assert.assertTrue(productServiceImplementation.isProductByNameAvailable("Staff"));
    }

    @Test
    public void testIsProductByNameAvailableWhenNot() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Assert.assertFalse(productServiceImplementation.isProductByNameAvailable("Example"));
    }

    @Test
    public void testIsProductByIdAvailable() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Assert.assertTrue(productServiceImplementation.isProductByIdAvailable(1l));
    }

    @Test
    public void testIsProductByIdAvailableWhenNot() {
        List<Product> productsArray = new ArrayList<Product>();
        productsArray.add(new Product(1l, "Box", 134.5f, 0.12f, "Blue", 23));
        productsArray.add(new Product(2l, "Package", 14.1f, 0.45f, "Red", 28));
        productsArray.add(new Product(3l, "Staff", 15, 0.15f, "Black", 27));
        ProductServiceImpl productServiceImplementation = new ProductServiceImpl(new ArrayList(productsArray));

        Assert.assertFalse(productServiceImplementation.isProductByIdAvailable(5l));
    }*/
}
