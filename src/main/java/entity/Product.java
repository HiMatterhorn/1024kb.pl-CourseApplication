package entity;

import entity.enums.Colors;
import entity.enums.ProductSeparators;

public class Product {
    private long id;
    private String productName;
    private float price;
    private float weight;
    private Colors color;
    private int productCount;


    public Product (Long id, String productName, float price, float weight, Colors color, int productCount){
        this.id = id;
        this.productName =productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }


    public Long getProductID (){
        return this.id;
    }

    public String getProductName () {
        return this.productName;
    }

    public float getPrice () {
        return this.price;
    }

    public void setPrice (float price){
        this.price = price;
    }

    public float getWeight () {
        return weight;
    }

    public Colors getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount (int productCount) {
        this.productCount = productCount;
    }

    protected String getBasicProductString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName + ProductSeparators.PRODUCT_SEPARATOR.toString() + price + ProductSeparators.PRODUCT_SEPARATOR.toString() + weight + ProductSeparators.PRODUCT_SEPARATOR.toString() + color + ProductSeparators.PRODUCT_SEPARATOR.toString() + productCount;
    }

    protected String endProductSign(){
        return "\n";
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + endProductSign();
    }

}
