package demo.compassites.mvpdemo.feature.products.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.MyApplication;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.feature.products.injection.component.DaggerPresenterComponent;
import demo.compassites.mvpdemo.feature.products.injection.component.PresenterComponent;
import demo.compassites.mvpdemo.feature.products.injection.module.ActivityBaseModule;
import demo.compassites.mvpdemo.feature.products.presenter.ProductDetailPresenter;
import demo.compassites.mvpdemo.feature.products.view.contract.ProductDetailsView;



public class ProductDetailActivity extends BaseActivity implements ProductDetailsView {
    public static final String EXTRA_PRODUCT = "PRODUCT";
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.title)
    TextView title;
    @Inject
    ProductDetailPresenter presenter;

    public static Intent getIntent(BaseActivity baseActivity) {
        return new Intent(baseActivity, ProductDetailActivity.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);
        PresenterComponent component = DaggerPresenterComponent
                .builder()
                .activityBaseModule(new ActivityBaseModule(this))
                .applicationComponent(((MyApplication) getApplicationContext()).getComponent())
                .build();
        component.injectProductDetails(this);
        ButterKnife.bind(this);
        presenter.attachView(ProductDetailActivity.this);
        presenter.getData();

    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setImageSrc(String url) {

    }

    @Override
    public void setPrice(String price) {
        this.price.setText(price);
    }



}
