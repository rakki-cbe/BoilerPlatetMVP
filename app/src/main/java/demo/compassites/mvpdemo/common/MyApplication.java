package demo.compassites.mvpdemo.common;

import demo.compassites.mvpdemo.feature.products.injection.component.ApplicationComponent;
import demo.compassites.mvpdemo.feature.products.injection.component.DaggerApplicationComponent;

/**
 * Created by radhakrishnan on 18/4/17.
 */
public class MyApplication extends com.activeandroid.app.Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
