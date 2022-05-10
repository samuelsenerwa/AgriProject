package com.agesadev.agriproject.network;

import com.agesadev.agriproject.model.TipsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("recommend")
    Call<List<TipsModel>> getRecommendedTips();

    @POST("question")
    Call<List<TipsModel>> searchTips(String search);

}
