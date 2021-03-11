package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReligionApi {

    public static void religions(final Context context, final List<String> religionlist, final Spinner spinner){
        WebService.getClient().religion().enqueue(new Callback<Religions>() {
            @Override
            public void onResponse(Call<Religions> call, Response<Religions> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                    religionlist.add(response.body().getDetail().get(i).getName());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, religionlist);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<Religions> call, Throwable t) {

            }
        });

    }
}
