
package demo.compassites.mvpdemo.feature.products.model.network;

import com.activeandroid.ActiveAndroid;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import demo.compassites.mvpdemo.feature.products.model.database.Product;

public class ProductList {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public ProductList() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void saveToDb() {
        if (products != null && products.size() > 0) {
            ActiveAndroid.beginTransaction();
            try {
                for (Product product : products) {
                    product.save();
                }
                ActiveAndroid.setTransactionSuccessful();
            } finally {
                ActiveAndroid.endTransaction();
            }
        }
    }

}
