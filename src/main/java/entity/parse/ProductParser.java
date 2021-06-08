package entity.parse;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Colors;
import entity.enums.Material;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

import java.awt.*;

public class ProductParser {

    public static Product stringToProduct(String productString) {

        final ProductSeparators productType = ProductSeparators.getIdByChar(productString.substring(0,1));
        switch (productType) {

            case PRODUCT_ID:
                return convertToProduct(productString);
            case BOOTS_ID:
                return convertToBoots(productString);
            case ClOTH_ID:
                return convertToCloth(productString);
        }
        return null;
    }


    private static Product convertToCloth(String productString) {
        String[] splittedProductString = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        Colors color = ColorParser.parseStringToColor(splittedProductString[5]);
        int productCount = Integer.parseInt(splittedProductString[6]);
        String size = splittedProductString[7];
        Material material = MaterialParser.parseStringToMaterial(splittedProductString[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToBoots(String productString) {
        String[] splittedProductString = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        Colors color = ColorParser.parseStringToColor(splittedProductString[5]);
        int productCount = Integer.parseInt(splittedProductString[6]);
        int size = Integer.parseInt(splittedProductString[7]);
        SkinType skinType = SkinParser.parseStringToSkinType(splittedProductString[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Product convertToProduct(String productString) {

        String[] splittedProductString = productString.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(splittedProductString[1]);
        String productName = splittedProductString[2];
        float price = Float.parseFloat(splittedProductString[3]);
        float weight = Float.parseFloat(splittedProductString[4]);
        Colors color = ColorParser.parseStringToColor(splittedProductString[5]);
        int productCount = Integer.parseInt(splittedProductString[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

}
