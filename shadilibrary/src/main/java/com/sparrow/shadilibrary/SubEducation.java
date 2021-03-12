package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubEducation {

    public static void subeducations(final Context context, final List<String> subedu, final Spinner spinner, String eid){

        WebService.getClient().subeducation(eid).enqueue(new Callback<Sub_education>() {
            @Override
            public void onResponse(Call<Sub_education> call, Response<Sub_education> response) {


                for(int i = 0;i< response.body().getDetail().size();i++){
                    subedu.add(response.body().getDetail().get(i).getSub_reg_name());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, subedu);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<Sub_education> call, Throwable t) {

            }
        });


    }
}
