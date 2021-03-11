package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ragister_One_Api {

    public static void ragisterone(final Context context, String name, String mobile, String gender, String email, String looking, String country, String dob, String password){

        WebService.getClient().ragistert1(name, mobile, gender, email, looking, country, dob, password).enqueue(new Callback<Ragister_one>() {
            @Override
            public void onResponse(Call<Ragister_one> call, Response<Ragister_one> response) {
                Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Ragister_one> call, Throwable t) {

            }
        });

    }
}
