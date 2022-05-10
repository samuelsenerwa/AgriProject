package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agesadev.agriproject.R;


public class TipsFragment extends Fragment {
    RecyclerView tipsFragmentRecycler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  tipsView= inflater.inflate(R.layout.fragment_tips, container, false);
        tipsFragmentRecycler=tipsView.findViewById(R.id.tipsFragmentRecycler);

        return tipsView;
    }
}