package demo.compassites.mvpdemo.feature.products.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.MyApplication;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.common.bus.ProductBus;
import demo.compassites.mvpdemo.feature.products.injection.component.DaggerPresenterComponent;
import demo.compassites.mvpdemo.feature.products.injection.component.PresenterComponent;
import demo.compassites.mvpdemo.feature.products.injection.module.ActivityBaseModule;
import demo.compassites.mvpdemo.feature.products.model.database.Product;
import demo.compassites.mvpdemo.feature.products.presenter.ProductListPresenter;
import demo.compassites.mvpdemo.feature.products.view.contract.ItemView;
import demo.compassites.mvpdemo.feature.products.view.contract.ListView;


public class ProductListActivity extends BaseActivity implements ListView, ItemView {
    @BindView(R.id.list_rv_products)
    RecyclerView list;
    @Inject
    ProgressDialog progress;
    @Inject
    ProductAdapter adapter;
    @Inject
    ProductListPresenter presenter;
    @Inject
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PresenterComponent component = DaggerPresenterComponent
                .builder()
                .activityBaseModule(new ActivityBaseModule(this))
                .applicationComponent(((MyApplication) getApplicationContext()).getComponent())
                .build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        component.injectProductListing(this);
        presenter.attachView(this);
        adapter.setItemView(this);
        list.setAdapter(adapter);
        list.setLayoutManager(layoutManager);
        presenter.getProductsList();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showProgress() {
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
        /*We used RXJava as Bus to send data*/
        ProductBus.getInstance().send(adapter.getItem(potion));
        startActivity(ProductDetailActivity.getIntent(this));

    }
}
