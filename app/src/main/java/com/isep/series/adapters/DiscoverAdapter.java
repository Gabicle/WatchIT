package com.isep.series.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.isep.series.R;
import com.isep.series.helpers.SeriesDiffCallback;
import com.isep.series.models.Entities.Series;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.MyViewHolder> {

    Context mContext;
    List<Series> mData;
    /*public DiscoverAdapter(Context mContext, List<Series> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
*/

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discover_card, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Series series = mData.get(position);
        holder.series_title.setText(series.getTitle());
        //TODO: MIGHT WANT TO ADD THE SEASONS STRING TO THE MODEL INSTEAD
        //holder.series_seasons.setText(series.getSeasons());
        if(series.getImage() != null)
        {
            String imageUrl = series.getImage().
                    replace("http://","https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.series_photo);
                    //.fitCenter().apply


        }
    }

    @Override
    public int getItemCount() {
        if(mData != null)
            return mData.size();
        else
            return 0;
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

    public void setmData(List<Series> mData) {

        final SeriesDiffCallback diffCallback = new SeriesDiffCallback(this.mData, mData);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        if(this.mData != null)
        {
            this.mData.clear();
            this.mData.addAll(mData);
        }
        diffResult.dispatchUpdatesTo(this);

    }


}
