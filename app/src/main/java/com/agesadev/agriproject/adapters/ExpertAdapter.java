package com.agesadev.agriproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agesadev.agriproject.model.Experts;
import com.agesadev.agriproject.R;

import java.util.ArrayList;

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.ExpertsViewHolder> {

    ArrayList<Experts> arrayList;
    Context context;

    public ExpertAdapter(ArrayList<Experts> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExpertsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_expert, parent, false);
        return new ExpertsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpertsViewHolder holder, int position) {
        Experts experts = arrayList.get(position);
        holder.eName.setText(experts.getExpertName());
        holder.expertRole.setText(experts.getExpertRole());
        holder.region.setText(experts.getRegion());
        holder.imageEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Email sent", Toast.LENGTH_SHORT).show();
            }
        });
        holder.phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Phone call made", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExpertsViewHolder extends RecyclerView.ViewHolder {
        TextView eName, region, contact, expertRole;
        ImageView phoneImage, imageEmail;

        public ExpertsViewHolder(@NonNull View itemView) {
            super(itemView);
            eName = itemView.findViewById(R.id.eName);
            region = itemView.findViewById(R.id.region);
            phoneImage = itemView.findViewById(R.id.phoneImage);
            imageEmail = itemView.findViewById(R.id.imageEmail);
            expertRole = itemView.findViewById(R.id.expertRole);
        }
    }
}
