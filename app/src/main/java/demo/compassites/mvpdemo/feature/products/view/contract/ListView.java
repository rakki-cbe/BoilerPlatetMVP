package demo.compassites.mvpdemo.feature.products.view.contract;

import java.util.List;

import demo.compassites.mvpdemo.common.base.BaseView;
import demo.compassites.mvpdemo.feature.products.model.database.Product;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public interface ListView extends BaseView {
    void showProgress();

    void stopProgress();

    void showError(String msg);

    void setProductList(List<Product> product);


}
