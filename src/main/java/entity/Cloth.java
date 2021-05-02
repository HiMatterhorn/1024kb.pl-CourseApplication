package entity;

public class Cloth extends Product {
    private String size;
    private String material;
    public final static char productType = 'C';

    public Cloth (Long id, String productName, float price, float weight, String color, int productCount, String size, String material){
        super (id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    String getSize () {
        return this.size;
    }

    String getMaterial () {
        return this.material;
    }

    @Override
    public String toString() {
        return productType + productSeparator + getBasicProductString() + productSeparator + size + productSeparator + material + endProductSign();
    }
}
