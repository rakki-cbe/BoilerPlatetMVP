package demo.compassites.mvpdemo.feature.Products.presenter;

import android.util.Log;

import demo.compassites.mvpdemo.common.base.BasePresenter;
import demo.compassites.mvpdemo.common.base.CustomException;
import demo.compassites.mvpdemo.common.bus.ProductBus;
import demo.compassites.mvpdemo.feature.Products.model.database.Product;
import demo.compassites.mvpdemo.feature.Products.view.contract.ProductDetailsView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailsView> {

    private Product product;

    public ProductDetailPresenter() {

    }

    public void getData() {
        ProductBus.getInstance().toObservable().ofType(Product.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Product>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("Succes", "Subscribed");
            }

            @Override
            public void onNext(Product value) {
                product = value;
                Log.d("Values", "Updated" + product.getProductPrice());
                applyData();

            }

            @Override
            public void onError(Throwable e) {
                Log.d("Succes", "error ");
            }

            @Override
            public void onComplete() {
                Log.d("Succes", "completed");
            }
        });

    }

    private void applyData() {

        if (product != null) {
            getBaseView().setPrice(product.getProductPrice());
            getBaseView().setTitle(product.getProductTitle());
        } else {
            throw new CustomException.dataNotAttached();
        }
        //getBaseView().setImageSrc(currentProduct.getImageDefault());

    }
}
