package com.sparrow.shadilibrary;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryApi {

    public static void contry(Context context, final List<String> countries){
        WebService.getClient().country().enqueue(new Callback<country>() {
            @Override
            public void onResponse(Call<country> call, Response<country> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                countries.add(response.body().getDetail().get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<country> call, Throwable t) {

            }
        });

    }
}
