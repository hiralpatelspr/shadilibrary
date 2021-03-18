package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Api {
    public  static void loginlist(final Context context,String mobile, String password){

        WebService.getClient().login(mobile,password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Toast.makeText(context, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }
}
