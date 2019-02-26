package ir.teeleh.elnaz.shoppinglistmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ir.teeleh.elnaz.shoppinglistmvp.R;
import ir.teeleh.elnaz.shoppinglistmvp.adapter.ShoppingListAdapter;
import ir.teeleh.elnaz.shoppinglistmvp.interfaces.mvpContracts;
import ir.teeleh.elnaz.shoppinglistmvp.model.Product;
import ir.teeleh.elnaz.shoppinglistmvp.presenter.ProductPresenter;

public class MainActivity extends AppCompatActivity implements mvpContracts.shoppingListView {

    ProductPresenter mProductPresenter;
    Button mAddButton;
    EditText mProductTileEditText;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddButton = findViewById(R.id.button_add);
        mProductTileEditText = findViewById(R.id.edit_text_item_title);
        mRecyclerView = findViewById(R.id.recycler_view_shopping_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProductPresenter.onAddButtonClick(mProductTileEditText.getText().toString());
            }
        });

        mProductPresenter = new ProductPresenter(this);
    }

    @Override
    public void updateList(ArrayList<Product> products) {
        if (mRecyclerView.getAdapter() == null) {
            ShoppingListAdapter adapter = new ShoppingListAdapter(products);
            mRecyclerView.setAdapter(adapter);
        } else {
            ShoppingListAdapter adapter = (ShoppingListAdapter) mRecyclerView.getAdapter();
            adapter.setDataList(products);
            adapter.notifyItemInserted(products.size() - 1);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
