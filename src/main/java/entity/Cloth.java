package entity;

import entity.enums.Colors;
import entity.enums.Material;
import entity.enums.ProductSeparators;

public class Cloth extends Product {
    private String size;
    private Material material;

    public Cloth (Long id, String productName, float price, float weight, Colors color, int productCount, String size, Material material){
        super (id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public Cloth (String productName, float price, float weight, Colors color, int productCount, String size, Material material){
        super (productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize () {
        return this.size;
    }

    public Material getMaterial () {
        return this.material;
    }

    @Override
    public String toString() {
        return ProductSeparators.ClOTH_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material + endProductSign();
    }
}
