package entity.parse;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String productString) {
        final char productType = productString.charAt(0);

        switch (productType) {

            case Product.productType:
                return convertToProduct(productString);
            case Boots.productType:
                return convertToBoots(productString);
            case Cloth.productType:
                return convertToCloth(productString);
        }
        return null;
    }


    private static Product convertToCloth(String productString) {
        String[] splittedProductString = productString.split(Product.productSeparator);

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        String color = splittedProductString[5];
        int productCount = Integer.parseInt(splittedProductString[6]);
        String size = splittedProductString[7];
        String material = splittedProductString[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productString) {
        String[] splittedProductString = productString.split(Product.productSeparator);

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        String color = splittedProductString[5];
        int productCount = Integer.parseInt(splittedProductString[6]);
        int size = Integer.parseInt(splittedProductString[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(splittedProductString[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Product convertToProduct(String productString) {

        String[] splittedProductString = productString.split(Product.productSeparator);

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        String color = splittedProductString[5];
        int productCount = Integer.parseInt(splittedProductString[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

}
