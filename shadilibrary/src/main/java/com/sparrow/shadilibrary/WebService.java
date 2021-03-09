package com.sparrow.shadilibrary;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class WebService {
    private static WebServiceInterface webApiInterface;


    public static WebServiceInterface getClient() {
        if (webApiInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okclient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://gohelvijay47932685.ipage.com/mrg_lib/")
                    .client(okclient)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            webApiInterface = client.create(WebServiceInterface.class);
        }
        return webApiInterface;
    }

    public interface WebServiceInterface {

        //register_one.php

        @POST
        @FormUrlEncoded
        Call<Ragister_one> ragistert1(
                @Field("name") String name,
                @Field("mobile") String mobile,
                @Field("gender") String gender,
                @Field("email") String email,
                @Field("looking") String looking,
                @Field("password") String password
        );

        @POST
        @FormUrlEncoded
        Call<Ragister_two> ragistert2(
                @Field("cast") String cast,
                @Field("mobile") String mobile,
                @Field("subcast") String subcast,
                @Field("education") String education,
                @Field("eduother") String eduother,
                @Field("password") String password
        );
    }
}
