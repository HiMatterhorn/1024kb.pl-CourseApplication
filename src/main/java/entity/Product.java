package entity;

public class Product {
    private long id;
    private String productName;
    private float price;
    private float weight;
    private String color;
    private int productCount;
    public static final String productSeparator = " #";
    public final static char productType = 'P';

    public Product (Long id, String productName, float price, float weight, String color, int productCount){
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

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount (int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return productType + productSeparator + " " + id + "." + productSeparator + productName + productSeparator + price + productSeparator + weight + productSeparator + color + productSeparator + productCount + productSeparator + "\n";
    }

}
