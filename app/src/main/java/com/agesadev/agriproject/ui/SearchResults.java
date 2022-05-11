package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.adapters.SearchRecyclerViewAdapter;
import com.agesadev.agriproject.model.SearchRequest;
import com.agesadev.agriproject.model.SearchResponse;
import com.agesadev.agriproject.model.TipsModel;
import com.agesadev.agriproject.network.ApiClient;
import com.agesadev.agriproject.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchResults extends Fragment {
    ApiInterface apiInterface;
    RecyclerView searchRecyclerView;
    ProgressBar loadingSearchResults;
    TextView loadingText;
    List<SearchResponse> searchResponses;
    SearchRecyclerViewAdapter searchRecyclerViewAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_results, container, false);
        initializeSearchResultsRecyclerView(view);
        loadingSearchResults = view.findViewById(R.id.progressBarSearch);
        loadingText = view.findViewById(R.id.loadingText);

        //get the query from the search view
        String query = getArguments().getString("query");
        Toast.makeText(view.getContext(), "The query gotten is" + query, Toast.LENGTH_SHORT).show();

        //get the api interface
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//        getSearchResults(query);
        displayDummyData();
        return view;
    }

    private void initializeSearchResultsRecyclerView(View view) {
        searchRecyclerView = view.findViewById(R.id.searchResultsRecyclerView);
        searchRecyclerViewAdapter = new SearchRecyclerViewAdapter(searchResponses, getContext());
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void displayDummyData() {
        List<SearchResponse> searchResponses = new ArrayList<>();
        searchResponses.add(new SearchResponse(
                "Jodi Henke",
                null,
                "https://www.agriculture.com/podcast/successful-farming-radio-podcast/goats-on-the-go",
                "Goats benefit our lives by eating weeds and brush that we want to get rid of. One goat rental company is taking goat benefits a step further.",
                "Goats On The Go"
        ));
        searchRecyclerView.setAdapter(new SearchRecyclerViewAdapter(searchResponses, getContext()));
        loadingSearchResults.setVisibility(View.GONE);
    }

    private void getSearchResults(String query) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.searchTips(query).enqueue(new Callback<List<SearchResponse>>() {
            @Override
            public void onResponse(Call<List<SearchResponse>> call, Response<List<SearchResponse>> response) {
                Log.d("TAG", "onLogResponse1: " + searchResponses);
                if (response.isSuccessful()) {
                    searchResponses = response.body();
                    Log.d("TAG", "onLogResponse: " + searchResponses);
                    Toast.makeText(getContext(), "Successful" + searchResponses, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed" + response.body(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<SearchResponse>> call, Throwable t) {
                Log.d("On Error", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getView().getContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        });

    }


}