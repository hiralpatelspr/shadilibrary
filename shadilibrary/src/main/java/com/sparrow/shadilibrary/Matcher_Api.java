package com.sparrow.shadilibrary;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Matcher_Api {
    public static void match(final Context context, String mobile, final List<List<match>> matchList){

        WebService.getClient().matcharray(mobile).enqueue(new Callback<MatchArray>() {
            @Override
            public void onResponse(Call<MatchArray> call, Response<MatchArray> response) {

                    matchList.add(response.body().getDetail());

            }

            @Override
            public void onFailure(Call<MatchArray> call, Throwable t) {

            }
        });

    }
}
