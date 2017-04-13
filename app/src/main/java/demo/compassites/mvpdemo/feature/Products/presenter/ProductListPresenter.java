package demo.compassites.mvpdemo.feature.Products.presenter;


import android.util.Log;

import demo.compassites.mvpdemo.common.base.BasePresenter;
import demo.compassites.mvpdemo.common.network.NetWorkHelper;
import demo.compassites.mvpdemo.feature.Products.model.Products;
import demo.compassites.mvpdemo.feature.Products.view.contract.ListView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ProductListPresenter extends BasePresenter<ListView> {
    public ProductListPresenter(ListView mView) {

    }

    public void getProductsList() {
        if (isViewAttached()) {
            getBaseView().showProgress();
            Observable<Products> observable = NetWorkHelper.getInstance().getClient().create(NetWorkHelper.NetworkInterface.class).getProductss();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Products>() {

                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(Products products) {
                            getBaseView().setProductList(products.getProducts());

                        }

                        @Override
                        public void onError(Throwable t) {
                            getBaseView().showError("Something wrong" + t.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {
                            getBaseView().stopProgress();
                            Log.d("Success", "----->complete");
                        }
                    });


        }

    }
}
