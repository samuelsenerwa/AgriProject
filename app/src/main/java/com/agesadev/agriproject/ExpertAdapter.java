package com.agesadev.agriproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpertAdapter extends RecyclerView.Adapter<ExpertAdapter.viewHolder> {

    ArrayList<Experts> arrayList;
    Context context;

    public ExpertAdapter(ArrayList<Experts> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_expert, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Experts experts = arrayList.get(position);
        holder.eName.setText(experts.geteName());
        holder.region.setText(experts.getRegion());
        holder.contact.setText(experts.getContact());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView eName, region, contact;
        ImageView phoneImage,imageEmail;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            eName = itemView.findViewById(R.id.eName);
//            region = itemView.findViewById(R.id.region);
            contact = itemView.findViewById(R.id.eContact);
            phoneImage=itemView.findViewById(R.id.phoneImage);
            imageEmail=itemView.findViewById(R.id.imageEmail);

        }
    }
}
