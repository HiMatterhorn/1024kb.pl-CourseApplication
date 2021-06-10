package entity;

import entity.enums.Colors;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class Boots extends Product {
    private int size;
    private SkinType skinType;


    public Boots (Long id, String productName, float price, float weight, Colors color, int productCount, int size, SkinType isNaturalSkin){
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = isNaturalSkin;
    }

    public Boots (String productName, float price, float weight, Colors color, int productCount, int size, SkinType isNaturalSkin){
        super(productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = isNaturalSkin;
    }

    public int getSize () {
        return this.size;
    }

    public SkinType getSkinType () {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + skinType + endProductSign();
    }
}
