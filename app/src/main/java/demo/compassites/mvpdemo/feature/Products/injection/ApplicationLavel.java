package demo.compassites.mvpdemo.feature.Products.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationLavel {
}
