package ir.teeleh.elnaz.shoppinglistmvp.presenter;

import ir.teeleh.elnaz.shoppinglistmvp.interfaces.mvpContracts;
import ir.teeleh.elnaz.shoppinglistmvp.model.Product;
import ir.teeleh.elnaz.shoppinglistmvp.model.ProductsList;

public class ProductPresenter implements mvpContracts.productPresenter {

    private Product mProduct;
    private ProductsList mProductsList;
    private mvpContracts.shoppingListView mView;


    public ProductPresenter(mvpContracts.shoppingListView view) {
        mView = view;
    }

    @Override
    public void onAddButtonClick(String newShoppingItemTitle) {
        if (mView != null) {
            mProduct = new Product(newShoppingItemTitle);
            mProductsList = ProductsList.getInstance();
            mProductsList.addProduct(mProduct);
            mView.updateList(mProductsList.getProducts());
        }
    }
}
