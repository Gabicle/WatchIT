package com.isep.series.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.isep.series.R;
import com.isep.series.models.Series;

import java.util.List;

public class SeriesFragmentAdapter extends RecyclerView.Adapter<SeriesFragmentAdapter.ViewHolder> {

    List<Series> mdata;

    public SeriesFragmentAdapter(List<Series> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_series, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //BINDS SERIES ITEM DATA HERE

        Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getThumbnail())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.imgSeries);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgSeries, imgChecked;
        TextView seriesTitle, seriesSeasons, episodesLeft, episodeTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSeries = itemView.findViewById(R.id.wl_series_img);
            imgChecked = itemView.findViewById(R.id.wl_check_icon);
            seriesTitle = itemView.findViewById(R.id.wl_series_title);
            seriesSeasons = itemView.findViewById(R.id.wl_seasons);
            episodesLeft = itemView.findViewById(R.id.wl_episodes_left);
            episodeTitle = itemView.findViewById(R.id.wl_episode_title);

        }
    }
}
