
package demo.compassites.mvpdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    @SerializedName("productDefault")
    @Expose
    private Integer productDefault;
    @SerializedName("imageDefault")
    @Expose
    private Integer imageDefault;
    @SerializedName("childViewType")
    @Expose
    private Integer childViewType;
    @SerializedName("productCode")
    @Expose
    private String productCode;
    @SerializedName("productPrice")
    @Expose
    private String productPrice;
    @SerializedName("productActualPrice")
    @Expose
    private String productActualPrice;
    @SerializedName("productDiscount")
    @Expose
    private String productDiscount;
    @SerializedName("productTitle")
    @Expose
    private String productTitle;
    @SerializedName("productMainCategory")
    @Expose
    private String productMainCategory;
    @SerializedName("productSubCategory")
    @Expose
    private String productSubCategory;
    @SerializedName("productCategory")
    @Expose
    private String productCategory;
    @SerializedName("productUrl")
    @Expose
    private List<String> productUrl = null;

    public Integer getProductDefault() {
        return productDefault;
    }

    public void setProductDefault(Integer productDefault) {
        this.productDefault = productDefault;
    }

    public Integer getImageDefault() {
        return imageDefault;
    }

    public void setImageDefault(Integer imageDefault) {
        this.imageDefault = imageDefault;
    }

    public Integer getChildViewType() {
        return childViewType;
    }

    public void setChildViewType(Integer childViewType) {
        this.childViewType = childViewType;
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
