package com.sparrow.shadilibrary;

import android.content.Context;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Matcher_Api {

    public static void match(final Context context, String mobile, final List<MatchList> matchList){

        WebService.getClient().matcharray(mobile).enqueue(new Callback<MatchArray>() {
            @Override
            public void onResponse(Call<MatchArray> call, Response<MatchArray> response) {
                for (int i = 0; i<response.body().getDetail().size();i++){
                    MatchList matchlist_array = new MatchList(response.body().getDetail().get(i).getDetail_bio(),
                            response.body().getDetail().get(i).getGender(),
                            response.body().getDetail().get(i).getId(),
                            response.body().getDetail().get(i).getLike_activite(),
                            response.body().getDetail().get(i).getMatch_religion(),
                            response.body().getDetail().get(i).getMcountry(),
                            response.body().getDetail().get(i).getMdiet(),
                            response.body().getDetail().get(i).getMeducation(),
                            response.body().getDetail().get(i).getName());
                    matchList.add(matchlist_array);
                }




            }

            @Override
            public void onFailure(Call<MatchArray> call, Throwable t) {

            }
        });

    }
}
