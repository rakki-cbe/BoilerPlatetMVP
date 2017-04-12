package demo.compassites.mvpdemo.network;

import demo.compassites.mvpdemo.model.Products;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by radhakrishanan on 7/4/17.
 */

public class NetWorkBuilder {
    private static final NetWorkBuilder ourInstance = new NetWorkBuilder();
    private static Retrofit retrofit = null;
    private String ENDPOINT = "https://api.myjson.com/";

    private NetWorkBuilder() {
    }

    public static NetWorkBuilder getInstance() {
        return ourInstance;
    }

    public Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface NetworkInterface {

        @GET("bins/njwbv")
        Call<Products> getProductss();

    }
}
