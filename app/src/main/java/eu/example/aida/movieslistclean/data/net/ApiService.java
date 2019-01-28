package eu.example.aida.movieslistclean.data.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aida on 1/1/2019.
 */

public class ApiService {

    String base_url;

    private ApiService(String base_url) {
        this.base_url = base_url;
    }

    static ApiService create(String base_url){
        return new ApiService(base_url);
    }

    public Retrofit getRetrofit(){
        OkHttpClient.Builder client=new OkHttpClient.Builder();

                client.readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(this.base_url)
                .client(client.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    <T> T create(final Class<T> apiService){
        return getRetrofit().create(apiService);
    }
}
