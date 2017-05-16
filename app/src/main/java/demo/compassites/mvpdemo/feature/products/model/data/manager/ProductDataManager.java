package demo.compassites.mvpdemo.feature.products.model.data.manager;

import com.activeandroid.query.Select;

import java.util.List;

import demo.compassites.mvpdemo.feature.products.model.database.Product;
import demo.compassites.mvpdemo.feature.products.model.network.NetWorkHelper;
import demo.compassites.mvpdemo.feature.products.model.network.ProductList;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by radhakrishnan on 14/4/17.
 * It will decide where to take the data server /Local
 */

public class ProductDataManager {
    private static ProductDataManager productDataManager;
    private ObservableEmitter<ProductList> productListEmitter;

    private ProductDataManager() {
    }

    public static ProductDataManager getInstance() {
        if (productDataManager == null) {
            synchronized (ProductDataManager.class) {
                productDataManager = new ProductDataManager();
            }
        }
        return productDataManager;


    }

    public Observable<ProductList> getProduct() {
        return Observable.create(new ObservableOnSubscribe<ProductList>() {
            @Override
            public void subscribe(ObservableEmitter<ProductList> emitter) throws Exception {
                ProductDataManager.this.productListEmitter = emitter;
                List<Product> p = new Select()
                        .from(Product.class)
                        .execute();

                if (p.size() > 0) {
                    ProductList productList = new ProductList();
                    productList.setProducts(p);
                    productListEmitter.onNext(productList);
                    productListEmitter.onComplete();
                } else {
                    Observable<ProductList> observable = NetWorkHelper.getInstance().getClient().create(NetWorkHelper.NetworkInterface.class).getProducts();
                    observable.subscribe(new Observer<ProductList>() {

                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(ProductList products) {
                            products.saveToDb();
                            List<Product> p = new Select()
                                    .from(Product.class)
                                    .execute();
                            products.setProducts(p);

                            productListEmitter.onNext(products);


                        }

                        @Override
                        public void onError(Throwable t) {
                            productListEmitter.onError(t);
                        }

                        @Override
                        public void onComplete() {
                            productListEmitter.onComplete();
                        }
                    });
                }
            }


        }).observeOn(Schedulers.io()).subscribeOn(Schedulers.io());


    }

}
