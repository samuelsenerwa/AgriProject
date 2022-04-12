package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.agesadev.agriproject.ExpertAdapter;
import com.agesadev.agriproject.Experts;
import com.agesadev.agriproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class ExpertsFragment extends Fragment {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    RecyclerView.Adapter rAdapter;
    ArrayList<Experts> arrayList = new ArrayList<>();
    ArrayAdapter<Experts> arrayAdapter;
    Experts experts;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_experts, container, false);

        recyclerView = view.findViewById(R.id.eList);
        recyclerView.setHasFixedSize(true);
        databaseReference = FirebaseDatabase.getInstance().getReference("Experts");



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Object eName = ds.child("eName").getValue();
                    Object contact = ds.child("contact").getValue();
                    Object region = ds.child("region").getValue();
                    Experts experts=new Experts(eName.toString(),region.toString(),contact.toString());
                    arrayList.add(experts);

                }

                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
                dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
                recyclerView.addItemDecoration(dividerItemDecoration);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                rAdapter = new ExpertAdapter(arrayList, getActivity());
                recyclerView.setAdapter(rAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }
}