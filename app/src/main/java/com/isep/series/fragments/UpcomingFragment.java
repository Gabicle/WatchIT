package com.isep.series.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.series.R;
import com.isep.series.adapters.SeriesFragmentAdapter;
import com.isep.series.adapters.UpcomingFragmentAdapter;
import com.isep.series.models.Entities.Series;

import java.util.ArrayList;
import java.util.List;


public class UpcomingFragment extends Fragment {

    RecyclerView rvSeriesUp;
private UpcomingFragmentAdapter upcomingFragAdapter;
    private List<Series> mdata;


    public UpcomingFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);

        initViews(view);
        initmdataSeries();
        setUpSeriesAdapter();

        return view;
    }

    private void setUpSeriesAdapter() {
        upcomingFragAdapter = new UpcomingFragmentAdapter(mdata);
        rvSeriesUp.setAdapter(upcomingFragAdapter);
    }

    private void initmdataSeries() {
        mdata = new ArrayList<>();
    }

    private void initViews(View view) {
        rvSeriesUp = view.findViewById(R.id.rv_upcoming);
        rvSeriesUp.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvSeriesUp.setHasFixedSize(true);
    }
}