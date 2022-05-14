package com.agesadev.agriproject.adapters;

import android.content.Context;
import android.content.Intent;
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
                String email = experts.getEmail();
                Toast.makeText(context, email, Toast.LENGTH_SHORT).show();
                //launch email app
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));

            }
        });
        holder.phoneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = experts.getContactPhone();
                Toast.makeText(context, phone, Toast.LENGTH_SHORT).show();
                //launch phone app
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(android.net.Uri.parse("tel:" + phone));
                context.startActivity(intent);
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
