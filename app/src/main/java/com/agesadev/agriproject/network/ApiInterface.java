package com.agesadev.agriproject.network;

import com.agesadev.agriproject.model.DetailedNews;
import com.agesadev.agriproject.model.SearchRequest;
import com.agesadev.agriproject.model.SearchResponse;
import com.agesadev.agriproject.model.TipsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("recommend")
    Call<List<TipsModel>> getRecommendedTips();
//
//    @POST("question")
//    Call<List<SearchResponse>> searchTips(@Body SearchRequest search);

    @POST("question")
    Call<List<SearchResponse>> searchTips(@Body String search);

    @POST("detail")
    Call<DetailedNews> getDetailedNews(@Body String search);


//    @POST("question")
//    Call<List<SearchResponse>> searchTips(@Body String search);


}
