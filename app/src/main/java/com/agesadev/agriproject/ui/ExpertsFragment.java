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
import android.widget.Toast;

import com.agesadev.agriproject.adapters.ExpertAdapter;
import com.agesadev.agriproject.model.Experts;
import com.agesadev.agriproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class ExpertsFragment extends Fragment {

    DatabaseReference databaseReference;
    RecyclerView expertsRecyclerView;
    RecyclerView.Adapter rAdapter;
    ArrayList<Experts> arrayList = new ArrayList<>();
//    ArrayAdapter<Experts> arrayAdapter;
    Experts experts;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_experts, container, false);
        expertsRecyclerView = view.findViewById(R.id.expertList);
        expertsRecyclerView.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference("Experts");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    experts = dataSnapshot.getValue(Experts.class);
                    arrayList.add(experts);
                }
                rAdapter = new ExpertAdapter(arrayList, getContext());
                expertsRecyclerView.setAdapter(rAdapter);
                expertsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error" + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}