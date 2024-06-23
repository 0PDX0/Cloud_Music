package com.example.wyymusic.podcast.fragment.adapter;

import android.content.Context;
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
import com.example.wyymusic.R;
import com.example.wyymusic.bean.MusicFm;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PodcastFmAdapter extends RecyclerView.Adapter<PodcastFmAdapter.MHolder> {

    private Context context;
    private List<MusicFm.DateDTO> list;

    public PodcastFmAdapter(Context context, List<MusicFm.DateDTO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_podcast_fm, parent, false));
    }

    @Override
    public void onBindViewHolder(MHolder holder, int position) {

        MusicFm.DateDTO data = list.get(position);

        Glide.with(context).load(data.getImgUrl()).transform(new CenterCrop(), new RoundedCorners(10))
                .into(holder.img);

        holder.music_name.setText(data.getMusicName());

        holder.album.setText(data.getAlbum());

        holder.play_sum.setText(data.getPlaySum());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        private TextView music_name;

        private TextView play_sum;

        private TextView album;


        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            music_name = itemView.findViewById(R.id.music_name);
            play_sum = itemView.findViewById(R.id.play_sum);
            album = itemView.findViewById(R.id.album);

        }
    }

}
