package com.sparrow.shadilibrary;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationApi {
    public static void educatuin(final Context context, final List<String> educationlist, final Spinner spinner){
        WebService.getClient().education().enqueue(new Callback<Education>() {
            @Override
            public void onResponse(Call<Education> call, Response<Education> response) {
                for(int i = 0;i< response.body().getDetail().size();i++){
                    educationlist.add(response.body().getDetail().get(i).getName());
                }

                ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context,
                        android.R.layout.simple_list_item_1, educationlist);
                adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adp1);
            }

            @Override
            public void onFailure(Call<Education> call, Throwable t) {

            }
        });

    }
}
