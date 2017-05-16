package demo.compassites.mvpdemo.feature.products.injection.module;

import dagger.Module;
import dagger.Provides;
import demo.compassites.mvpdemo.feature.products.model.data.manager.ProductDataManager;

/**
 * Created by radhakrishnan on 16/5/17.
 */
@Module
public class DataManagerModule {
    @Provides
    ProductDataManager getProductDataManager() {
        return ProductDataManager.getInstance();
    }
}
