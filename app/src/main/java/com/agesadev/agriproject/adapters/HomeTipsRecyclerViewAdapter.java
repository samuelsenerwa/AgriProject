package com.agesadev.agriproject.adapters;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.model.TipsModel;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeTipsRecyclerViewAdapter extends RecyclerView.Adapter<HomeTipsRecyclerViewAdapter.HomeTipsViewHolder> {
    List<TipsModel> homeRecommendations;
    Context context;

    public HomeTipsRecyclerViewAdapter(List<TipsModel> homeRecommendations, Context context) {
        this.homeRecommendations = homeRecommendations;
        this.context = context;
    }


    @NonNull
    @Override
    public HomeTipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_tip_home, parent, false);
        return new HomeTipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeTipsViewHolder holder, int position) {
        TipsModel tipsModel = homeRecommendations.get(position);
        holder.newsTitle.setText(tipsModel.getTitle());
        holder.newsDescription.setText(tipsModel.getText());
//        Glide.with(context).load(tipsModel.getImage()).transition(withCrossFade()).into(holder.recommendationImage);
        if (homeRecommendations.get(position).getImage() != null) {
            Glide.with(context)
                    .load(homeRecommendations
                            .get(position)
                            .getImage())
                    .placeholder(R.drawable.agi_placeholder)
                    .error(R.drawable.agi_placeholder)
                    .transition(withCrossFade())
                    .into(holder.recommendationImage);
        } else {
            Glide.with(context)
                    .load(R.drawable.agi_placeholder)
                    .placeholder(R.drawable.agi_placeholder)
                    .error(R.drawable.agi_placeholder)
                    .transition(withCrossFade())
                    .into(holder.recommendationImage);
        }
        holder.singleHomTipCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, tipsModel.getTitle(), Toast.LENGTH_SHORT).show();
//              display the bottom sheet dialog with url to open the webview
                displayFullArticle(tipsModel);

            }
        });
    }

    private void displayFullArticle(TipsModel tipsModel) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_tips_layout, null);

        WebView homeWebView = view.findViewById(R.id.tipsWebView);
        FloatingActionButton backFloatingActionBtn = view.findViewById(R.id.closeWebView);
        homeWebView.loadUrl(tipsModel.getLink());
        WebViewClient client = new WebViewClient();
        backFloatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        homeWebView.setWebViewClient(client);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }


    @Override
    public int getItemCount() {
        if (homeRecommendations.size() == 0) {
            return 0;
        } else {
            return homeRecommendations.size();
        }
    }

    public class HomeTipsViewHolder extends RecyclerView.ViewHolder {
        ImageView recommendationImage, shareIcon, downloadIcon;
        TextView newsTitle, newsDescription;
        MaterialCardView singleHomTipCard;


        public HomeTipsViewHolder(@NonNull View itemView) {
            super(itemView);
            recommendationImage = itemView.findViewById(R.id.tipImage);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            newsTitle = itemView.findViewById(R.id.newsTitle);
            shareIcon = itemView.findViewById(R.id.share);
            downloadIcon = itemView.findViewById(R.id.downloadNews);
            singleHomTipCard = itemView.findViewById(R.id.singleHomeCard);

        }


    }
}
