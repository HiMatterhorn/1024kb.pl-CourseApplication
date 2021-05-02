package entity;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;
    public final static char productType = 'B';

    public Boots (Long id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin){
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    int getSize () {
        return this.size;
    }

    boolean madeOfSkin () {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return productType + productSeparator + getBasicProductString() + productSeparator + size + productSeparator + isNaturalSkin + endProductSign();
    }
}
