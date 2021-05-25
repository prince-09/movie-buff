package com.moneypati.moviewbuff.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moneypati.moviewbuff.service.APIServices;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //http://image.tmdb.org/t/p/original/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg [original,w300, w780, w1280]

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static APIClient instance;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private Retrofit retrofit;
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build();

    private APIClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    private APIClient(int TIMEOUT) {

        final OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }

    public static synchronized APIClient getInstance() {

        if (instance == null) {
            instance = new APIClient();
        }
        return instance;
    }

    public static synchronized APIClient getInstance(int TIMEOUT) {

        if (instance == null) {
            instance = new APIClient(TIMEOUT);
        }
        return instance;
    }

    public APIServices getApi() {
        return retrofit.create(APIServices.class);
    }
}
