package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ragister_Two_Api {

    public static void ragistertwo(final Context context,  String mobile, String cast, String subcast, String education, String eduother){

        WebService.getClient().ragistert2(mobile,cast,subcast,education,eduother).enqueue(new Callback<Ragister_two>() {
            @Override
            public void onResponse(Call<Ragister_two> call, Response<Ragister_two> response) {
                Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Ragister_two> call, Throwable t) {

            }
        });

    }
}
