package demo.compassites.mvpdemo.feature.Products.presenter;

import demo.compassites.mvpdemo.common.base.BasePresenter;
import demo.compassites.mvpdemo.feature.Products.model.Product;
import demo.compassites.mvpdemo.feature.Products.view.contract.ProductDetailsView;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailsView> {

    private Product currentProduct;

    public ProductDetailPresenter(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public void setData() {


        getBaseView().setPrice(currentProduct.getProductPrice());
        getBaseView().setTitle(currentProduct.getProductTitle());
        //getBaseView().setImageSrc(currentProduct.getImageDefault());

    }
}
