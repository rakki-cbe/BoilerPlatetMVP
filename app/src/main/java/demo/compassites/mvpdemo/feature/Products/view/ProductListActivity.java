package demo.compassites.mvpdemo.feature.Products.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.common.bus.ProductBus;
import demo.compassites.mvpdemo.feature.Products.model.Product;
import demo.compassites.mvpdemo.feature.Products.presenter.ProductListPresenter;
import demo.compassites.mvpdemo.feature.Products.view.contract.ItemView;
import demo.compassites.mvpdemo.feature.Products.view.contract.ListView;


public class ProductListActivity extends BaseActivity implements ListView, ItemView {
    @BindView(R.id.list_rv_products)
    RecyclerView list;
    ProgressDialog progress;
    ProductAdapter adapter;
    private ProductListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        presenter = new ProductListPresenter(this);
        presenter.attachView(this);
        adapter = new ProductAdapter(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        presenter.getProductsList();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("");
        progress.setIndeterminate(true);
        progress.show();


    }

    @Override
    public void stopProgress() {
        if (progress != null && progress.isShowing()) progress.dismiss();

    }

    @Override
    public void showError(String msg) {
        super.showToast(msg);
    }

    @Override
    public void setProductList(List<Product> product) {
        adapter.setList(product);
    }


    @Override
    public void onItemClicked(int potion) {
        startActivity(ProductDetailActivity.getIntent(this));
        /*We used RXJava as Bus to send data*/
        ProductBus.getInstance().send(adapter.getItem(potion));
    }
}
