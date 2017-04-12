package demo.compassites.mvpdemo.feature.Products.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.feature.Products.view.interfaces.ItemView;

/**
 * Created by radhakrishanan on 7/4/17.
 */

class ProductItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.IP_name)
    private TextView tv_name;
    private ItemView callBack;
    private int position;

    ProductItemHolder(View itemView, ItemView mItemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        callBack = mItemView;
        tv_name.setOnClickListener(this);
    }


    void setName(String title) {
        tv_name.setText(title);

    }

    void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onClick(View v) {
        callBack.onItemClicked(position);
    }
}
