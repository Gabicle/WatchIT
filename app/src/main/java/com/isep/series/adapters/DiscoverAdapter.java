package com.isep.series.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.series.R;
import com.isep.series.models.Series;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.MyViewHolder> {

    Context mContext;
    List<Series> mData;

    public DiscoverAdapter(Context mContext, List<Series> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_discover_card, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.series_photo.setImageResource(mData.get(position).getThumbnail());
        holder.series_title.setText(mData.get(position).getTitle());
        //TODO: MIGHT WANT TO ADD THE SEASONS STRING TO THE MODEL INSTEAD
        holder.series_seasons.setText(mData.get(position).getSeasons());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView series_photo;
        TextView series_title, series_seasons;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            series_photo = itemView.findViewById(R.id.discover_card_bg);
            series_title = itemView.findViewById(R.id.discover_series_title);
            series_seasons = itemView.findViewById(R.id.discover_series_seasons);
        }
    }
}
