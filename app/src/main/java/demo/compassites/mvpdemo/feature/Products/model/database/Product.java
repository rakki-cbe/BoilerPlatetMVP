package demo.compassites.mvpdemo.feature.Products.model.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

@Table(name = "Product")
public class Product extends Model implements Serializable {
    @Column(name = "code")//,unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    private String productCode;
    @Column(name = "price")
    private String productPrice;
    @Column(name = "acual_price")
    private String productActualPrice;
    @Column(name = "discount")
    private String productDiscount;
    @Column(name = "title")
    private String productTitle;
    @Column(name = "main_category")
    private String productMainCategory;
    @Column(name = "sub_Category")
    private String productSubCategory;
    @Column(name = "category")
    private String productCategory;
    private List<String> productUrl = null;

    public Product() {
        super();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductActualPrice() {
        return productActualPrice;
    }

    public void setProductActualPrice(String productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductMainCategory() {
        return productMainCategory;
    }

    public void setProductMainCategory(String productMainCategory) {
        this.productMainCategory = productMainCategory;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<String> getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(List<String> productUrl) {
        this.productUrl = productUrl;
    }

}
