package ir.teeleh.elnaz.shoppinglistmvp.model;

public class Product {
    String mTitle;

    public Product(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
