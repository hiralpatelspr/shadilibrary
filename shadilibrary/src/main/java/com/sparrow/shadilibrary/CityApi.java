package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityApi {
    public static void city(final Context context, final List<String> city, final Spinner spinner, String cid){

        WebService.getClient().cities(cid).enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                    city.add(response.body().getDetail().get(i).getSub_city_name());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, city);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {

            }
        });

    }

}
