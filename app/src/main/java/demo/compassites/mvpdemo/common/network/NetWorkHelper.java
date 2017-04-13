package demo.compassites.mvpdemo.common.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import demo.compassites.mvpdemo.feature.Products.model.Products;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class NetWorkHelper {
    private static final NetWorkHelper ourInstance = new NetWorkHelper();
    private static Retrofit retrofit = null;
    private String END_POINT = "https://api.myjson.com/";

    private NetWorkHelper() {
    }

    public static NetWorkHelper getInstance() {
        return ourInstance;
    }

    public Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(END_POINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //.addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface NetworkInterface {

        @GET("bins/njwbv")
        Observable<Products> getProductss();

    }
}
