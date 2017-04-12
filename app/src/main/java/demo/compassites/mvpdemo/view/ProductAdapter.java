package demo.compassites.mvpdemo.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.model.Product;
import demo.compassites.mvpdemo.view.interfaces.ItemView;

/**
 * Created by radhakrishanan on 7/4/17.
 */

class ProductAdapter extends RecyclerView.Adapter<ProductItemHolder> {
    private List<Product> list = new ArrayList<>();
    private ItemView mItemView;

    ProductAdapter(ItemView view) {
        mItemView = view;
    }

    @Override
    public ProductItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View holerView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductItemHolder(holerView, mItemView);
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
