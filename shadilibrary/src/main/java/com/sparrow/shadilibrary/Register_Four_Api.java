package com.sparrow.shadilibrary;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Four_Api {

    public  static void registerfourapi(final Context context,String mobile,String profession,
                                        String income,String state,String city,String lfamily,
                                        String btype,String fstatus,String complexion,String diet){

        Log.d("TAG", "registerfourapi: "+mobile+ profession+income+state+ city+lfamily+
                btype+fstatus+ complexion+ diet);
        WebService.getClient().ragistert4(mobile, profession, income, state, city, lfamily,
                btype, fstatus, complexion, diet).enqueue(new Callback<Register_four>() {
            @Override
            public void onResponse(@NotNull Call<Register_four> call, @NotNull Response<Register_four> response) {
                assert response.body() != null;
                Toast.makeText(context, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NotNull Call<Register_four> call, @NotNull Throwable t) {


            }
        });

    }

}
