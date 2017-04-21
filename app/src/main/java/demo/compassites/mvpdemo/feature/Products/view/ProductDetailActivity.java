package demo.compassites.mvpdemo.feature.Products.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.feature.Products.presenter.ProductDetailPresenter;
import demo.compassites.mvpdemo.feature.Products.view.contract.ProductDetailsView;



public class ProductDetailActivity extends BaseActivity implements ProductDetailsView {
    public static final String EXTRA_PRODUCT = "PRODUCT";
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.title)
    TextView title;
    ProductDetailPresenter presenter = new ProductDetailPresenter();

    public static Intent getIntent(BaseActivity baseActivity) {
        return new Intent(baseActivity, ProductDetailActivity.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);
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
