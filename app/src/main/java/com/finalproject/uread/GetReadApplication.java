package com.finalproject.uread;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by paulo.losbanos on 10/02/2017.
 */

public class GetReadApplication extends Application {

    public static Retrofit mRetrofit;
    //public final String BASE_URL = "http://192.168.0.101:8082"; //url of firebase app
    public final String BASE_URL = "http://172.20.10.2:8082"; // hotspot

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();

        Log.e("rank","application");
    }
}
