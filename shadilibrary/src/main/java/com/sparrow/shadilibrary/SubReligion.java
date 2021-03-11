package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubReligion {

    public static void subreligions(final Context context, final List<String> state, final Spinner spinner, String rid){

        WebService.getClient().subreligion(rid).enqueue(new Callback<Sub_Religion>() {
            @Override
            public void onResponse(Call<Sub_Religion> call, Response<Sub_Religion> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                    state.add(response.body().getDetail().get(i).getSub_reg_name());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, state);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<Sub_Religion> call, Throwable t) {

            }
        });

    }
}
