package demo.compassites.mvpdemo.feature.Products.presenter;

import demo.compassites.mvpdemo.common.base.BasePresenter;
import demo.compassites.mvpdemo.common.network.NetWorkHelper;
import demo.compassites.mvpdemo.feature.Products.model.Products;
import demo.compassites.mvpdemo.feature.Products.view.interfaces.ListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ProductListPresenter extends BasePresenter<ListView> {
    public ProductListPresenter(ListView mView) {

    }

    public void getProductsList() {
        if (isViewAttached()) {
            getBaseView().showProgress();
            NetWorkHelper.getInstance().getClient().create(NetWorkHelper.NetworkInterface.class).getProductss().enqueue(new Callback<Products>() {
                @Override
                public void onResponse(Call<Products> call, Response<Products> response) {
                    getBaseView().stopProgress();
                    if (response.isSuccessful()) {
                        Products mProducts = response.body();
                        getBaseView().setProductList(mProducts.getProducts());
                    }
                }

                @Override
                public void onFailure(Call<Products> call, Throwable t) {
                    getBaseView().stopProgress();
                    getBaseView().showError("Something Wrong");
                }
            });
        }

    }
}
