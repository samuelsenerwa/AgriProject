package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agesadev.agriproject.R;


public class SearchResults extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_results, container, false);
        //get the query from the search view
        String query = getArguments().getString("query");
        Toast.makeText(view.getContext(), "The query gotten is" + query, Toast.LENGTH_SHORT).show();

        return view;
    }
}