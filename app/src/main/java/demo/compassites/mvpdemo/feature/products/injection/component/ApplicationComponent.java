package demo.compassites.mvpdemo.feature.products.injection.component;

import android.content.Context;

import dagger.Component;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@Component
public interface ApplicationComponent {
    void inject(Context context);
}
