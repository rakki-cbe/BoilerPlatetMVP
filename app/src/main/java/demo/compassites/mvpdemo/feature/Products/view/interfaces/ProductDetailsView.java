package demo.compassites.mvpdemo.feature.Products.view.interfaces;

import demo.compassites.mvpdemo.common.base.BaseView;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public interface ProductDetailsView extends BaseView {
    void setTitle(String title);

    void setImageSrc(String url);

    void setPrice(String price);

}