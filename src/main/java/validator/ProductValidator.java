package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {
    //Singleton
    private static ProductValidator instanceProductValidator = null;

    public static ProductValidator getInstance() {
        if (instanceProductValidator == null) {
            instanceProductValidator = new ProductValidator();
        }
        return instanceProductValidator;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
        if (!isProductPricePositive(product.getPrice())) {
            throw new ProductPriceNoPositiveException("Price parameter is not positive");
        }

        if (!isProductCountPositive(product.getProductCount())) {
            throw new ProductCountNegativeException("Count parameter is not positive");
        }

        if (!isProductWeightPositive(product.getWeight())) {
            throw new ProductWeightNoPositiveException("Weight parameter is not positive");
        }

        if (!isProductNameNotNull(product.getProductName())) {
            throw new ProductNameEmptyException("Product name is empty");
        }

        return true;
    }


    private boolean isProductPricePositive(Float price) {
        return price > 0f;
    }

    private boolean isProductCountPositive(Integer count) {
        return count > 0;
    }

    private boolean isProductWeightPositive(Float weight) {
        return weight > 0f;
    }

    private boolean isProductNameNotNull(String name) {
        return name.length() != 0;
    }
}
