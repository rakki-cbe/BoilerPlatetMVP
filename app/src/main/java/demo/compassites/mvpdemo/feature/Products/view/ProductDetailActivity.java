package demo.compassites.mvpdemo.feature.Products.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.compassites.mvpdemo.R;
import demo.compassites.mvpdemo.common.base.BaseActivity;
import demo.compassites.mvpdemo.common.bus.ProductBus;
import demo.compassites.mvpdemo.feature.Products.model.Product;
import demo.compassites.mvpdemo.feature.Products.presenter.ProductDetailPresenter;
import demo.compassites.mvpdemo.feature.Products.view.contract.ProductDetailsView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ProductDetailActivity extends BaseActivity implements ProductDetailsView {
    public static final String EXTRA_PRODUCT = "PRODUCT";
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.title)
    TextView title;
    ProductDetailPresenter presenter;

    public static Intent getIntent(BaseActivity baseActivity) {
        return new Intent(baseActivity, ProductDetailActivity.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);
        ButterKnife.bind(this);
        getData();
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

    /**
     * We used RXJava as Bus to receive data
     */
    public void getData() {
        ProductBus.getInstance().toObservable().ofType(Product.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Product>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("Succes", "sdjksdfjh1");
            }

            @Override
            public void onNext(Product value) {
                presenter = new ProductDetailPresenter(value);
                presenter.attachView(ProductDetailActivity.this);
                presenter.setData();

            }

            @Override
            public void onError(Throwable e) {
                Log.d("Succes", "sdjksdfjh3");
            }

            @Override
            public void onComplete() {
                Log.d("Succes", "sdjksdfjh4");
            }
        });

    }
}
