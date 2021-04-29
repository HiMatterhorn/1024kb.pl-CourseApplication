package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {
    //Singleton
    private static ProductValidator instanceProductValidator = null;

    public static ProductValidator getInstanceProductValidator() {
        if (instanceProductValidator == null) {
            instanceProductValidator = new ProductValidator();
        }
        return instanceProductValidator;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
        if (!isProductPricePositive(product.getPrice())) {
            throw new ProductPriceNoPositiveException();
        }

        if (!isProductCountPositive(product.getProductCount())) {
            throw new ProductCountNegativeException();
        }

        if (!isProductWeightPositive(product.getWeight())) {
            throw new ProductWeightNoPositiveException();
        }

        if (!isProductNameNotNull(product.getProductName())) {
            throw new ProductNameEmptyException();
        }

        return true;
    }


    private boolean isProductPricePositive(Float price) {
        return price > 0;
    }

    private boolean isProductCountPositive(Integer count) {
        return count > 0;
    }

    private boolean isProductWeightPositive(Float weight) {
        return weight > 0;
    }

    private boolean isProductNameNotNull(String name) {
        if (name != null && name != "") {
            return true;
        }
        return false;
    }
}
