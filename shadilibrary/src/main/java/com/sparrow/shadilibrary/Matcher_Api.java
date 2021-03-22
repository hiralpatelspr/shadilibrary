package com.sparrow.shadilibrary;

import android.content.Context;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Matcher_Api {

    public static void match(final Context context, String mobile, final List<match_array> matchList){

        WebService.getClient().matcharray(mobile).enqueue(new Callback<MatchArray>() {
            @Override
            public void onResponse(Call<MatchArray> call, Response<MatchArray> response) {
                for (int i = 0; i<response.body().getDetail().size();i++){
                    match_array matchlist_array = new match_array(response.body().getDetail().get(i).getDetail_bio(),
                            response.body().getDetail().get(i).getGender(),
                            response.body().getDetail().get(i).getId(),
                            response.body().getDetail().get(i).getLike_activite(),
                            response.body().getDetail().get(i).getMatch_religion(),
                            response.body().getDetail().get(i).getMcountry(),
                            response.body().getDetail().get(i).getMdiet(),
                            response.body().getDetail().get(i).getMeducation(),
                            response.body().getDetail().get(i).getName());
                    matchList.add(matchlist_array);

                    Log.d("TAG", "onResponse: "+matchList);
                }




            }

            @Override
            public void onFailure(Call<MatchArray> call, Throwable t) {

            }
        });

    }
}
