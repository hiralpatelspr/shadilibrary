package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Three_Api {

    public static void registerThreeApi(final Context context, String mobile, String height,String weight,
                                        String living,String birth,String nationality){

        WebService.getClient().ragistert3(mobile, height, weight, living, birth, nationality).enqueue(new Callback<Ragister_three>() {
            @Override
            public void onResponse(@NotNull Call<Ragister_three> call, @NotNull Response<Ragister_three> response) {
                assert response.body() != null;
                Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NotNull Call<Ragister_three> call, @NotNull Throwable t) {

            }
        });


    }

}
