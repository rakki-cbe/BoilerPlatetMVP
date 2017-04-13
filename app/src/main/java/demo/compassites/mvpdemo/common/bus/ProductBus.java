package demo.compassites.mvpdemo.common.bus;

import demo.compassites.mvpdemo.feature.Products.model.Product;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by radhakrishnan on 13/4/17.
 * Its a bus used can act as sender also receiver
 */

public class ProductBus {
    private static final ProductBus ourInstance = new ProductBus();
    private final BehaviorSubject<Product> bus = BehaviorSubject.create();

    private ProductBus() {
    }

    public static ProductBus getInstance() {
        return ourInstance;
    }

    public void send(Product event) {
        bus.onNext(event);
    }

    public Observable<Product> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
