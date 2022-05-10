package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.adapters.HomeTipsRecyclerViewAdapter;
import com.agesadev.agriproject.model.TipsModel;
import com.agesadev.agriproject.network.ApiClient;
import com.agesadev.agriproject.network.ApiInterface;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    RecyclerView homeRecyclerview;
    ProgressBar homeProgressBar;
    TextView loadingText;
    ApiInterface apiInterface;
    List<TipsModel> homeTipsRecommendations;
    Button retryButton;
    SearchView tipsSearchView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeRecyclerview = view.findViewById(R.id.homeRecyclerview);
        homeProgressBar = view.findViewById(R.id.progressBarHome);
        loadingText = view.findViewById(R.id.loadingText);
        retryButton = view.findViewById(R.id.retryButton);
        tipsSearchView = view.findViewById(R.id.searchTips);

        homeRecyclerview.setLayoutManager(new LinearLayoutManager(view.getContext()));
        makeAPICall();
        handleUserSearch();

        return view;
    }

    private void handleUserSearch() {
        tipsSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                passTheSearchQuery(query);
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void passTheSearchQuery(String query) {
        String searchQuery = query.toLowerCase().trim();
//        Toast.makeText(getContext(), "The query is " + searchQuery, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("query", searchQuery);
        Navigation.findNavController(tipsSearchView).navigate(R.id.action_homeFragment_to_searchResults, bundle);
    }


    private void makeAPICall() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface.getRecommendedTips().enqueue(new Callback<List<TipsModel>>() {
            @Override
            public void onResponse(Call<List<TipsModel>> call, Response<List<TipsModel>> response) {
                Log.d("Log Response", "onResponse: " + response.body());
                //check if response array length is greater than 0
                if (response.body().size() > 0) {
                    homeTipsRecommendations = response.body();
                    homeProgressBar.setVisibility(View.GONE);
                    loadingText.setVisibility(View.GONE);
                    homeRecyclerview.setAdapter(new HomeTipsRecyclerViewAdapter(homeTipsRecommendations, getContext()));
                } else {
                    Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
                    retryButton.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<TipsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Network Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setUpRecyclerView() {


    }
}