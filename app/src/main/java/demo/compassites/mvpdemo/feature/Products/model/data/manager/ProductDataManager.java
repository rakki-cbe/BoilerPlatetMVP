package demo.compassites.mvpdemo.feature.Products.model.data.manager;

import com.activeandroid.query.Select;

import java.util.List;

import demo.compassites.mvpdemo.feature.Products.model.database.Product;
import demo.compassites.mvpdemo.feature.Products.model.network.NetWorkHelper;
import demo.compassites.mvpdemo.feature.Products.model.network.ProductList;
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
    private static final ProductDataManager ourInstance = new ProductDataManager();

    private ProductDataManager() {
    }

    public static ProductDataManager getInstance() {
        return ourInstance;
    }

    public Observable<ProductList> getProduct() {
        Observable<ProductList> observable1 = Observable.create(new ObservableOnSubscribe<ProductList>() {
            @Override
            public void subscribe(final ObservableEmitter<ProductList> e) throws Exception {
                List<Product> p = new Select()
                        .from(Product.class)
                        .execute();

                if (p.size() > 0) {
                    ProductList productList = new ProductList();
                    productList.setProducts(p);
                    e.onNext(productList);
                    e.onComplete();
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

                            e.onNext(products);
                            e.onComplete();

                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
                }
            }


        }).observeOn(Schedulers.io()).subscribeOn(Schedulers.io());


        return observable1;

    }

}
