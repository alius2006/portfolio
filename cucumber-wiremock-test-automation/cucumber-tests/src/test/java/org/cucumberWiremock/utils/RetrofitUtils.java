package org.cucumberWiremock.utils;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitUtils {

    public static Retrofit getRetrofit(String url) {

        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Object executeCall(Call<?> call) {

        Response<?> response;

        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
