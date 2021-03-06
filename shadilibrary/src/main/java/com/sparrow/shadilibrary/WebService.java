package com.sparrow.shadilibrary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://gohelvijay47932685.ipage.com/mrg_lib/")
                    .client(okclient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            webApiInterface = client.create(WebServiceInterface.class);
        }
        return webApiInterface;
    }

    public interface WebServiceInterface {

        //register_one.php

        @POST("register_one.php")
        @FormUrlEncoded
        Call<Ragister_one> ragistert1(

                @Field("name") String name,
                @Field("mobile") String mobile,
                @Field("gender") String gender,
                @Field("email") String email,
                @Field("looking") String looking,
                @Field("country") String country,
                @Field("dob") String dob,
                @Field("password") String password
        );

        @POST("register_two.php")
        @FormUrlEncoded
        Call<Ragister_two> ragistert2(
                @Field("mobile") String mobile,
                @Field("cast") String cast,
                @Field("subcast") String subcast,
                @Field("education") String education,
                @Field("eduother") String eduother
        );


        @POST("register_three.php")
        @FormUrlEncoded
        Call<Registe_three> ragistert3(
                @Field("mobile") String mobile,
                @Field("mstatus") String mstatus,
                @Field("height") String height,
                @Field("weight") String weight,
                @Field("living") String living,
                @Field("birth") String birth,
                @Field("nationality") String nationality
        );

        //register_four.php
        @POST("register_four.php")
        @FormUrlEncoded
        Call<Register_four> ragistert4(

                @Field("mobile") String mobile,
                @Field("profession") String profession,
                @Field("income") String income,
                @Field("state") String state,
                @Field("city") String city,
                @Field("lfamily") String lfamily,
                @Field("btype") String btype,
                @Field("fstatus") String fstatus,
                @Field("complexion") String complexion,
                @Field("diet") String diet
        );

        @POST("register_five.php")
        @FormUrlEncoded
        Call<Register_five> ragistert5(

                @Field("mobile") String mobile,
                @Field("mstatus") String mstatus,
                @Field("mreligion") String mreligion,
                @Field("meducation") String meducation,
                @Field("mcountry") String mcountry,
                @Field("lookingfor") String lookingfor,
                @Field("mdiet") String mdiet,
                @Field("detailbio") String detailbio,
                @Field("likeactivite") String likeactivite
        );

        @POST("states.php")
        @FormUrlEncoded
        Call<States> states(

                @Field("sid") String sid
        );


        @POST("cities.php")
        @FormUrlEncoded
        Call<Cities> cities(

                @Field("cid") String cid
        );

        @POST("sub_education.php")
        @FormUrlEncoded
        Call<Sub_education> subeducation(

                @Field("eid") String eid
        );

        //sub_religion.php

        @POST("sub_religion.php")
        @FormUrlEncoded
        Call<Sub_Religion> subreligion(

                @Field("rid") String rid
        );

        @GET("country.php")
        Call<country> country();

        @GET("education.php")
        Call<Education> education();

        @GET("religion.php")
        Call<Religions> religion();

        //login.php
        @POST("login.php")
        @FormUrlEncoded
        Call<Login> login(

                @Field("mobile") String mobile,
                @Field("password") String password
        );

        //match.php
        @POST("match.php")
        @FormUrlEncoded
        Call<MatchArray> matcharray(

                @Field("mobile_no") String mobile

        );
    }
}
