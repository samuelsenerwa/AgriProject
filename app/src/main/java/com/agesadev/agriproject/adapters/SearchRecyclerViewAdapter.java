package com.agesadev.agriproject.adapters;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.model.SearchResponse;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchResultsViewHolder> {
    List<SearchResponse> searchResponses;
    Context context;

    public SearchRecyclerViewAdapter(List<SearchResponse> searchResponses, Context context) {
        this.searchResponses = searchResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_search_result, parent, false);
        return new SearchResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultsViewHolder holder, int position) {
        SearchResponse searchResponse = searchResponses.get(position);
        holder.searchResultTitle.setText(searchResponse.getTitle());
        holder.searchResultDescription.setText(searchResponse.getText());
        holder.searchResultContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("urlLink", searchResponse.getLink());
                Toast.makeText(context, searchResponse.getLink(), Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_searchResults_to_detailedSearchResult, bundle);
//                displayDetailedResult(searchResponse);

            }
        });

    }


    @Override
    public int getItemCount() {
        return searchResponses.size();
    }

    public class SearchResultsViewHolder extends RecyclerView.ViewHolder {
        TextView searchResultTitle, searchResultDescription;
        ConstraintLayout searchResultContainer;

        public SearchResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            searchResultTitle = itemView.findViewById(R.id.resultTitle);
            searchResultDescription = itemView.findViewById(R.id.resultDescription);
            searchResultContainer = itemView.findViewById(R.id.searchResultsItem);
        }
    }
}
