package com.agesadev.agriproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.model.Tips;

import java.util.List;

public class TipsRecyclerViewAdapter extends RecyclerView.Adapter<TipsRecyclerViewAdapter.Myview>{
    List<Tips> tips;
    Context context;

    public TipsRecyclerViewAdapter(Context context, List<Tips> tips){
        this.context = context;
        this.tips = tips;
    }

    @NonNull
    @Override
    public TipsRecyclerViewAdapter.Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tips_item,parent,false);
        return new Myview(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TipsRecyclerViewAdapter.Myview holder, int position) {
        holder.title.setText(tips.get(position).getName());
        holder.description.setText(tips.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return tips.size();
    }

    public class Myview  extends RecyclerView.ViewHolder  {
        TextView title,description;
        public Myview(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.content);
        }
    }
}