package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryApi {

    public static void contry(final Context context, final List<String> countries, final Spinner spinner){
        WebService.getClient().country().enqueue(new Callback<country>() {
            @Override
            public void onResponse(Call<country> call, Response<country> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                countries.add(response.body().getDetail().get(i).getName());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, countries);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<country> call, Throwable t) {

            }
        });

    }
}
