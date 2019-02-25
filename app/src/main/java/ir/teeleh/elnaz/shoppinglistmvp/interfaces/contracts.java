package ir.teeleh.elnaz.shoppinglistmvp.interfaces;

import java.util.ArrayList;

import ir.teeleh.elnaz.shoppinglistmvp.model.Product;

public interface contracts {
    interface shoppingListView {
        void updateList(ArrayList<Product> products);

        void showProgress();

        void hideProgress();
    }

    interface productPresenter {
        void onAddButtonClick(String newShoppingItemTitle);
    }


}
