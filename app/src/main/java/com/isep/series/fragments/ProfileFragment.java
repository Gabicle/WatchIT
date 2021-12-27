package com.isep.series.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.series.R;
import com.isep.series.models.Series;
import com.isep.series.adapters.ProfileAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView profileRV;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // RECYCLER VIEW HERE
        List<Series>  seriesList = new ArrayList<>();

        //TODO: PUT THE USER'S SERIES LIST HERE
        seriesList.add(new Series("Moana", R.drawable.timg1));
        seriesList.add(new Series("Moana", R.drawable.timg1));
        seriesList.add(new Series("Constantine", R.drawable.timg2));
        seriesList.add(new Series("Constantine", R.drawable.timg2));
        seriesList.add(new Series("Oralsese", R.drawable.timg1));
        seriesList.add(new Series("Oralsese", R.drawable.timg1));

        profileRV = view.findViewById(R.id.rv_profile_series);

        ProfileAdapter profileAdapter = new ProfileAdapter(view.getContext(), seriesList);

        profileRV.setAdapter(profileAdapter);
        profileRV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));



        return view;
    }
}
