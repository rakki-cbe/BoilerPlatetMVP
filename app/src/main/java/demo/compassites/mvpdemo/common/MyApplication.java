package demo.compassites.mvpdemo.common;

import demo.compassites.mvpdemo.feature.Products.injection.component.ApplicationComponent;
import demo.compassites.mvpdemo.feature.Products.injection.component.DaggerApplicationComponent;

/**
 * Created by radhakrishnan on 18/4/17.
 */
public class MyApplication extends com.activeandroid.app.Application {

    ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
