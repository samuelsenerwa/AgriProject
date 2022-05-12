package com.agesadev.agriproject.ui;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

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
import com.agesadev.agriproject.model.SearchRequest;
import com.agesadev.agriproject.network.ApiClient;
import com.agesadev.agriproject.network.ApiInterface;
import com.bumptech.glide.Glide;

import java.util.List;

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
        Toast.makeText(view.getContext(), "The url at detailed is  " + search, Toast.LENGTH_SHORT).show();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setData(search);
        getDetailedSearchResult(searchRequest);

        return view;
    }

    private void getDetailedSearchResult(SearchRequest urlLink) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.getDetailedNews(urlLink).enqueue(new Callback<List<DetailedNews>>() {
            @Override
            public void onResponse(Call<List<DetailedNews>> call, Response<List<DetailedNews>> response) {
                displayDetailedResult(response);
            }

            @Override
            public void onFailure(Call<List<DetailedNews>> call, Throwable t) {
                Toast.makeText(getContext(), "An Error Occurred" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Detailed", "onFailure: " + t.getLocalizedMessage());

            }
        });

    }

    private void displayDetailedResult(Response<List<DetailedNews>> response) {
        if (response.isSuccessful()) {
            DetailedNews detailedNews = response.body().get(0);
            detailedTextViewItem.setText(detailedNews.getTitle());
            for (int i = 0; i < detailedNews.getText().length; i++) {
                detailedTextViewItemDescription.append(detailedNews.getText()[i]);
            }

            Glide.with(getContext())
                    .load(detailedNews.getImage())
                    .transition(withCrossFade())
                    .placeholder(R.drawable.agi_placeholder)
                    .into(detailedImageViewItem);

            Log.d("Detailed", "onResponse: " + response.body());
        } else {
            Toast.makeText(getContext(), "No Results Found", Toast.LENGTH_SHORT).show();
        }
    }
}