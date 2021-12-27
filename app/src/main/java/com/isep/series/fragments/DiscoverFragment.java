package com.isep.series.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.series.R;
import com.isep.series.models.Series;
import com.isep.series.adapters.DiscoverAdapter;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private RecyclerView discoverRV;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_discover, container, false);


        //sets status bar to transparent
        Window w = getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //RECYCLER VIEW ADAPTER SETUP
        discoverRV = view.findViewById(R.id.rv_discover_series);

        List<Series>  seriesList = new ArrayList<>();

        seriesList.add(new Series("Stranger Things", R.drawable.testimg1, "2 seasons"));
        seriesList.add(new Series("Portable Life", R.drawable.testimg2, "3 seasons"));
        seriesList.add(new Series("Stranger Things", R.drawable.testimg2, "4 seasons"));
        seriesList.add(new Series("Portable Life", R.drawable.testimg2, "3 seasons"));
        seriesList.add(new Series("Portable Life", R.drawable.testimg2, "3 seasons"));
        seriesList.add(new Series("Stranger Things", R.drawable.testimg2, "4 seasons"));
        seriesList.add(new Series("Portable Life", R.drawable.testimg2, "3 seasons"));



        DiscoverAdapter discoverAdapter = new DiscoverAdapter(view.getContext(),seriesList);

        discoverRV.setAdapter(discoverAdapter);
        discoverRV.setLayoutManager(new LinearLayoutManager(view.getContext()));




        return view;
    }


}
