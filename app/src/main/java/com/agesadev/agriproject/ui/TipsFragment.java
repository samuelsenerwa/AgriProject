package com.agesadev.agriproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agesadev.agriproject.R;
import com.agesadev.agriproject.adapters.TipsRecyclerViewAdapter;
import com.agesadev.agriproject.model.Tips;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TipsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ProgressBar progressBar;
    RecyclerView.LayoutManager manager;
    List<Tips> tips = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        progressBar=view.findViewById(R.id.progressBar);
        manager = new LinearLayoutManager(getActivity());
        adapter = new TipsRecyclerViewAdapter(getActivity(), tips);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        Thread thread=new Thread(new Runnable() {
            Document document;
            @Override
            public void run() {
                try {
                    document= Jsoup.connect("https://www.goatfarming.in/goat-farming-questions-answers").get();

                    Element div=document.getElementsByClass("tdb-block-inner td-fix-index").get(6);
                    Elements children = div.children();

                    for (Element element:children){
                        String data= element.text();
                        String quiz=element.getElementsByTag("span").text();
                        String answer = element.getElementsByTag("p").text();
                        Tips tip = new Tips(quiz,answer);
                        tips.add(tip);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(tips!=null){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                            Toast.makeText(getContext(), tips.toString(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            progressBar.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));

                        }
                    });

                }




            }
        }); thread.start();


        return view;
    }
}