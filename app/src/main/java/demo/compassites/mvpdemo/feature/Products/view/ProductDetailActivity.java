package demo.compassites.mvpdemo.feature.Products.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.feature.Products.model.Product;
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
    ProductDetailPresenter presenter;

    public static Intent getIntent(BaseActivity baseActivity, Product product) {
        Intent in = new Intent(baseActivity, ProductDetailActivity.class);
        in.putExtra(EXTRA_PRODUCT, product);
        return in;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);
        ButterKnife.bind(this);
        presenter = new ProductDetailPresenter((Product) getIntent().getExtras().getSerializable(EXTRA_PRODUCT));
        presenter.attachView(this);
        presenter.setData();


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
