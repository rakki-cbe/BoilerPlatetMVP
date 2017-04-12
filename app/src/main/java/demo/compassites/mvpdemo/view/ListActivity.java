package demo.compassites.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.model.Product;
import demo.compassites.mvpdemo.presenter.ListPresenter;
import demo.compassites.mvpdemo.view.interfaces.ItemView;
import demo.compassites.mvpdemo.view.interfaces.ListView;

public class ListActivity extends BaseActivity implements ListView, ItemView {
    @BindView(R.id.list_rv_products)
    RecyclerView list;
    ProgressDialog progress;
    ProductAdapter adapter;
    private ListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        mPresenter = new ListPresenter(this);
        mPresenter.attachView(this);
        adapter = new ProductAdapter(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.getProductsList();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
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
    public void OnItemClicked(int potion) {
        startActivity(ProductDetailActivity.getIntent(this, adapter.getItem(potion)));
    }
}
