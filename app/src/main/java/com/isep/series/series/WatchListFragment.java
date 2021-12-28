package com.isep.series.series;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.series.R;
import com.isep.series.Series;

import java.util.ArrayList;
import java.util.List;


public class WatchListFragment extends Fragment {

    private RecyclerView rvSeries;
    private SeriesFragmentAdapter seriesFragAdapter;
    private List<Series> mdata;



    public WatchListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_watch_list, container, false);
        
        initViews(view);
        initmdataSeries();
        setUpSeriesAdapter();
        
        return view;
    }

    private void setUpSeriesAdapter() {
        seriesFragAdapter = new SeriesFragmentAdapter(mdata);
        rvSeries.setAdapter(seriesFragAdapter);
    }

    //TODO: LOAD USER SERIES DATA
    private void initmdataSeries() {
        mdata = new ArrayList<>();

        //FOR PERSONAL TESTING OF UI (TO BE DELETED)
        mdata.add(new Series("The Crown", R.drawable.testimg1, "S01"));
        mdata.add(new Series("The Crown", R.drawable.testimg1, "S01"));
        mdata.add(new Series("The Crown", R.drawable.testimg1, "S01"));
        mdata.add(new Series("The Crown", R.drawable.testimg1, "S01"));
        mdata.add(new Series("The Crown", R.drawable.testimg1, "S01"));
    }

    private void initViews(View view) {
        rvSeries = view.findViewById(R.id.rv_watchlist);
        rvSeries.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvSeries.setHasFixedSize(true);
    }
}