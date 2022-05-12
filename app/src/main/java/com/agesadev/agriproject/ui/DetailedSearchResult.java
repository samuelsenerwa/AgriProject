package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.model.DetailedNews;
import com.agesadev.agriproject.network.ApiClient;
import com.agesadev.agriproject.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedSearchResult extends Fragment {

    ApiInterface apiInterface;
    ImageView detailedImageViewItem;
    TextView detailedTextViewItem, detailedTextViewItemDescription;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detailed_search_result, container, false);
        detailedImageViewItem = view.findViewById(R.id.resultImage);
        detailedTextViewItem = view.findViewById(R.id.singleResultTitle);
        detailedTextViewItemDescription = view.findViewById(R.id.fullNewsArticle);
        Bundle bundle = getArguments();
        String search = bundle.getString("urlLink");
        Toast.makeText(view.getContext(), "The url link is " + search, Toast.LENGTH_SHORT).show();
        getDetailedSearchResult(search);


        return view;
    }

    private void getDetailedSearchResult(String urlLink) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DetailedNews> call = apiInterface.getDetailedNews(urlLink);
        call.enqueue(new Callback<DetailedNews>() {
            @Override
            public void onResponse(Call<DetailedNews> call, Response<DetailedNews> response) {
                Log.d("onDetailed", "More details is : " + response.body());
                Toast.makeText(getContext(), "The data is " + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DetailedNews> call, Throwable t) {
                Toast.makeText(getContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}