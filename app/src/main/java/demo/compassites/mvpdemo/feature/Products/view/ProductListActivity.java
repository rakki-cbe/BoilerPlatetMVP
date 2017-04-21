package demo.compassites.mvpdemo.feature.Products.view;

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
import demo.compassites.mvpdemo.feature.Products.injection.PerActivity;
import demo.compassites.mvpdemo.feature.Products.injection.component.DaggerPresenterComponent;
import demo.compassites.mvpdemo.feature.Products.injection.component.PresenterComponent;
import demo.compassites.mvpdemo.feature.Products.injection.module.ProgressDialogModule;
import demo.compassites.mvpdemo.feature.Products.model.database.Product;
import demo.compassites.mvpdemo.feature.Products.presenter.ProductListPresenter;
import demo.compassites.mvpdemo.feature.Products.view.contract.ItemView;
import demo.compassites.mvpdemo.feature.Products.view.contract.ListView;

@PerActivity
public class ProductListActivity extends BaseActivity implements ListView, ItemView {
    @BindView(R.id.list_rv_products)
    RecyclerView list;
    @Inject
    ProgressDialog progress;
    @Inject
    ProductAdapter adapter;
    @Inject
    ProductListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PresenterComponent component = DaggerPresenterComponent
                .builder()
                .progressDialogModule(new ProgressDialogModule(this))
                .applicationComponent(((MyApplication) getApplicationContext()).getComponent())
                .build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        component.inject(this);


        presenter.attachView(this);
        adapter.setItemView(this);
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
