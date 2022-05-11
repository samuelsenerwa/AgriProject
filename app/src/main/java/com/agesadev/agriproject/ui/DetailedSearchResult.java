package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agesadev.agriproject.R;

public class DetailedSearchResult extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detailed_search_result, container, false);
        Bundle bundle = getArguments();
        String search = bundle.getString("urlLink");
        Toast.makeText(view.getContext(), "The query gotten is" + search, Toast.LENGTH_SHORT).show();

        return view;
    }
}