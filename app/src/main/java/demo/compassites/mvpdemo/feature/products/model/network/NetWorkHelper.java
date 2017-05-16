package demo.compassites.mvpdemo.feature.products.model.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Created by radhakrishanan on 7/4/17.
 */

public class NetWorkHelper {
    private static final NetWorkHelper ourInstance = new NetWorkHelper();
    private static Retrofit retrofit = null;
    final private String END_POINT = "https://api.myjson.com/";

    private NetWorkHelper() {
    }

    public static NetWorkHelper getInstance() {
        return ourInstance;
    }

    public Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(END_POINT)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public interface NetworkInterface {

        @GET("bins/njwbv")
        Observable<ProductList> getProducts();

    }
}
