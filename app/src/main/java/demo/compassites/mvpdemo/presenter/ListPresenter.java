package demo.compassites.mvpdemo.presenter;

import demo.compassites.mvpdemo.model.Products;
import demo.compassites.mvpdemo.network.NetWorkBuilder;
import demo.compassites.mvpdemo.view.interfaces.ListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ListPresenter extends BasePresenter<ListView> {
    public ListPresenter(ListView mView) {

    }

    public void getProductsList() {
        if (isViewAttached()) {
            getBaseView().showProgress();
            NetWorkBuilder.getInstance().getClient().create(NetWorkBuilder.NetworkInterface.class).getProductss().enqueue(new Callback<Products>() {
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
