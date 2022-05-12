package com.agesadev.agriproject.ui;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
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
    List<SearchRequest> searchResponses;
    List<SearchResponse> searchResponsesResult;
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
        loadingText = view.findViewById(R.id.loadingTextViewSearch);

        //get the query from the search view
        String query = getArguments().getString("query");

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setData(query);
        getSearchResults(searchRequest);

        return view;
    }

    private void initializeSearchResultsRecyclerView(View view) {
        searchRecyclerView = view.findViewById(R.id.searchResultsRecyclerView);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void getSearchResults(SearchRequest searchRequest) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.searchTips(searchRequest).enqueue(new Callback<List<SearchResponse>>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<List<SearchResponse>> call, Response<List<SearchResponse>> response) {
                if (response.isSuccessful()) {
                    searchResponsesResult = response.body();
                    displaySearchResults();
                } else {
                    displayWhenNoResultIsFound(response);
                }

            }
            @Override
            public void onFailure(Call<List<SearchResponse>> call, Throwable t) {
                Log.d("On Error", "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getView().getContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void displayWhenNoResultIsFound(Response<List<SearchResponse>> response) {
        loadingText.setText("No results found");
        loadingText.setTextSize(25);
        loadingText.setTextAppearance(R.style.TextView_NoResults);
        Toast.makeText(getContext(), "Failed" + response.body(), Toast.LENGTH_SHORT).show();
    }

    private void displaySearchResults() {
        searchRecyclerViewAdapter = new SearchRecyclerViewAdapter(searchResponsesResult, getContext());
        searchRecyclerView.setAdapter(searchRecyclerViewAdapter);
        searchRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        loadingSearchResults.setVisibility(View.GONE);
        loadingText.setVisibility(View.GONE);
    }


}