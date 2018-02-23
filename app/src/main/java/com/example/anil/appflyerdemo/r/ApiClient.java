package com.example.anil.appflyerdemo.r;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anil on 2/22/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://52.5.205.129:3001/";


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private void d() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getAppVersion("en");
        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(final Call<CommonResponse> call, final Response<CommonResponse> response) {
                Log.e("ddddd", "ddddd " + response.message() + response.body().toString());
            }

            @Override
            public void onFailure(final Call<CommonResponse> call, final Throwable t) {

            }
        });
    }

}
