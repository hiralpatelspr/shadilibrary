package com.sparrow.shadilibrary;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_five_api {

    public  static void registerfiveapi(final Context context, String mobile, String mstatus,
                                        String mreligion, String meducation, String mcountry, String lookingfor,
                                        String mdiet, String detailbio, String likeactivite){


        WebService.getClient().ragistert5(mobile,mstatus,mreligion,meducation,mcountry,lookingfor,mdiet,detailbio,likeactivite).enqueue(new Callback<Register_five>() {
            @Override
            public void onResponse(@NotNull Call<Register_five> call, @NotNull Response<Register_five> response) {
                assert response.body() != null;
                Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NotNull Call<Register_five> call, @NotNull Throwable t) {


            }
        });}
}
