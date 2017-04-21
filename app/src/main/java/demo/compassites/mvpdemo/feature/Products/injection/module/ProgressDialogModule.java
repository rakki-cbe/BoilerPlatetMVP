package demo.compassites.mvpdemo.feature.Products.injection.module;

import android.app.ProgressDialog;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by radhakrishnan on 20/4/17.
 */
@Module
public class ProgressDialogModule {

    private Context mContext;

    public ProgressDialogModule(Context context) {
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

}
