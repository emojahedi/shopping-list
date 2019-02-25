package ir.teeleh.elnaz.shoppinglistmvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ir.teeleh.elnaz.shoppinglistmvp.R;
import ir.teeleh.elnaz.shoppinglistmvp.model.Product;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {
    private ArrayList<Product> dataList;

    public ShoppingListAdapter(ArrayList<Product> dataList) {
        this.dataList = dataList;
    }

    public void setDataList(ArrayList<Product> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.shopping_row, parent, false);
        return new ShoppingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {
        holder.txtProductTitle.setText(dataList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ShoppingListViewHolder extends RecyclerView.ViewHolder {

        TextView txtProductTitle;

        ShoppingListViewHolder(View itemView) {
            super(itemView);
            txtProductTitle = itemView.findViewById(R.id.txt_item_title);
        }
    }


}
