package demo.compassites.mvpdemo.feature.products.injection.component;

import dagger.Component;
import demo.compassites.mvpdemo.feature.products.injection.module.ActivityBaseModule;
import demo.compassites.mvpdemo.feature.products.injection.module.DataManagerModule;
import demo.compassites.mvpdemo.feature.products.view.ProductDetailActivity;
import demo.compassites.mvpdemo.feature.products.view.ProductListActivity;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@Component(modules = {ActivityBaseModule.class, DataManagerModule.class}, dependencies = {ApplicationComponent.class})
public interface PresenterComponent {

    void injectProductListing(ProductListActivity Activity);

    void injectProductDetails(ProductDetailActivity Activity);

}
