package demo.compassites.mvpdemo.feature.products.injection.module;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@Module
public class ActivityBaseModule {

    private Context mContext;

    public ActivityBaseModule(Context context) {
        mContext = context;
    }

    @Provides
    Context getContext() {
        return mContext;
    }


    @Provides
    ProgressDialog getProgressDialog(Context context) {
        return new ProgressDialog(context);
    }

    @Provides
    LinearLayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

}
