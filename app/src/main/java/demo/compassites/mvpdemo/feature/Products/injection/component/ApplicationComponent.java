package demo.compassites.mvpdemo.feature.Products.injection.component;

import android.content.Context;

import dagger.Component;
import demo.compassites.mvpdemo.feature.Products.injection.ApplicationLavel;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@ApplicationLavel
@Component
public interface ApplicationComponent {
    void inject(Context context);
}
