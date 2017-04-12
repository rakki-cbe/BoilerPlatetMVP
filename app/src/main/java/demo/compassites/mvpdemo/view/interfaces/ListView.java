package demo.compassites.mvpdemo.view.interfaces;

import java.util.List;

import demo.compassites.mvpdemo.model.Product;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public interface ListView extends BaseView {
    void showProgress();

    void stopProgress();

    void showError(String msg);

    void setProductList(List<Product> product);


}