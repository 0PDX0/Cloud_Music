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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.wyymusic.R;

import org.jetbrains.annotations.NotNull;

public class PodcastServerAdapter extends RecyclerView.Adapter<PodcastServerAdapter.MHolder> {

    private Context context;
    private String[] names;
    private int[] imgs;

    public PodcastServerAdapter(Context context, String[] names, int[] imgs){
        this.context = context;
        this.names = names;
        this.imgs = imgs;
    }

    @Override
    public MHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_podcast_server, null));
    }

    @Override
    public void onBindViewHolder( MHolder holder, int position) {

        Glide.with(context).load(imgs[position]).transform(new CircleCrop())
                .into(holder.img);

        holder.name.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView name;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }


}
