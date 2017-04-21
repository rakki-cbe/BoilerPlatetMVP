package demo.compassites.mvpdemo.feature.Products.injection.component;

import dagger.Component;
import demo.compassites.mvpdemo.feature.Products.injection.PerActivity;
import demo.compassites.mvpdemo.feature.Products.injection.module.ProgressDialogModule;
import demo.compassites.mvpdemo.feature.Products.view.ProductListActivity;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@PerActivity
@Component(modules = {ProgressDialogModule.class}, dependencies = {ApplicationComponent.class})
public interface PresenterComponent {

    void inject(ProductListActivity productListActivity);

}
