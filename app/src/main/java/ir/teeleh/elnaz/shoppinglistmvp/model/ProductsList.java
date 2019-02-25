package ir.teeleh.elnaz.shoppinglistmvp.model;

import java.util.ArrayList;

public class ProductsList {

    ArrayList<Product> mProducts;
    private static ProductsList productsList;

    public static ProductsList getInstance() {
        if (productsList == null) {
            productsList = new ProductsList();
        }
        return productsList;
    }

    private ProductsList() {
        mProducts = new ArrayList<>();
    }


    public ArrayList<Product> getProducts() {
        return mProducts;
    }

    public void addProduct(Product product) {
        mProducts.add(product);
    }
}
