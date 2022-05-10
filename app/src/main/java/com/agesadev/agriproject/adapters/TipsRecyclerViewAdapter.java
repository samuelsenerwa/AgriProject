package com.agesadev.agriproject.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agesadev.agriproject.model.TipsModel;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class TipsRecyclerViewAdapter extends RecyclerView.Adapter<TipsRecyclerViewAdapter.TipsViewHolder> {
    List<TipsModel> agricultureTips;
    Context context;

    public TipsRecyclerViewAdapter(List<TipsModel> agricultureTips, Context context) {
        this.agricultureTips = agricultureTips;
        this.context = context;
    }

    @NonNull
    @Override
    public TipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TipsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TipsViewHolder extends RecyclerView.ViewHolder {
        ImageView recommendationImage, shareIcon, downloadIcon;
        TextView newsTitle, newsDescription;
        MaterialCardView singleHomTipCard;

        public TipsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
