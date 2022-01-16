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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.series.R;
import com.isep.series.models.Series;
import com.isep.series.adapters.DiscoverAdapter;
import com.isep.series.models.allTvSeries;
import com.isep.series.viewmodels.TvSeriesViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private RecyclerView discoverRV;
    private TvSeriesViewHolder viewModel;
    private DiscoverAdapter discoverAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        discoverAdapter = new DiscoverAdapter();

        viewModel = ViewModelProviders.of(this).get(TvSeriesViewHolder.class);
        viewModel.init();

        viewModel.getTvSeriesResponseLiveData().observe(this, new Observer<allTvSeries>() {

            @Override
            public void onChanged(allTvSeries tvSeriesResponse) {
                if (tvSeriesResponse != null) {
                    discoverAdapter.setmData(tvSeriesResponse.getItems());
                }
            }
        });

        viewModel.searchTVSeries();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_discover, container, false);


        //sets status bar to transparent
        Window w = getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //RECYCLER VIEW ADAPTER SETUP
        discoverRV = view.findViewById(R.id.rv_discover_series);
        discoverRV.setLayoutManager(new LinearLayoutManager(view.getContext()));
        discoverRV.setAdapter(discoverAdapter);
        return view;
    }


}
