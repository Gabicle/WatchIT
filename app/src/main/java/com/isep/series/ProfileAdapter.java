package com.isep.series;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    Context context;
    List<Series> mData;

    public ProfileAdapter(Context context, List<Series> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_profile_series, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.seriesTitle.setText(mData.get(position).getTitle());
        holder.seriesImg.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView seriesTitle;
        private ImageView seriesImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            seriesTitle = itemView.findViewById(R.id.item_series_title);
            seriesImg = itemView.findViewById(R.id.item_series_img);
        }
    }
}
