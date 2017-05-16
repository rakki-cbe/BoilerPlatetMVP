package demo.compassites.mvpdemo.feature.products.presenter;


import javax.inject.Inject;

import demo.compassites.mvpdemo.common.base.BasePresenter;
import demo.compassites.mvpdemo.feature.products.model.data.manager.ProductDataManager;
import demo.compassites.mvpdemo.feature.products.model.network.ProductList;
import demo.compassites.mvpdemo.feature.products.view.contract.ListView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ProductListPresenter extends BasePresenter<ListView> {
    @Inject
    ProductDataManager dataManager;

    @Inject
    public ProductListPresenter() {

    }

    public void getProductsList() {
        if (isViewAttached()) {
            getBaseView().showProgress();
            Observable<ProductList> data = dataManager.getProduct();
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ProductList>() {

                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(ProductList products) {
                            getBaseView().setProductList(products.getProducts());

                        }

                        @Override
                        public void onError(Throwable t) {
                            t.printStackTrace();
                            getBaseView().showError("Something wrong" + t.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {
                            getBaseView().stopProgress();

                        }
                    });

        }

    }
}
