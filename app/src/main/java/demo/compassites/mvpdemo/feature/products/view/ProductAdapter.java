package demo.compassites.mvpdemo.feature.products.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.feature.products.model.database.Product;
import demo.compassites.mvpdemo.feature.products.view.contract.ItemView;


/**
 * Created by radhakrishanan on 7/4/17.
 */

class ProductAdapter extends RecyclerView.Adapter<ProductItemHolder> {
    private List<Product> list = new ArrayList<>();
    private ItemView itemView;

    @Inject
    ProductAdapter() {

    }

    void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }

    @Override
    public ProductItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View holderView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductItemHolder(holderView, itemView);
    }

    @Override
    public void onBindViewHolder(ProductItemHolder holder, int position) {
        holder.setPosition(position);
        holder.setName(getItem(position).getProductTitle());
    }

    void setList(List<Product> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    Product getItem(int position) throws ArrayIndexOutOfBoundsException {
        return list.get(position);
    }
}
