package com.example.wyymusic.home.server.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;

import org.jetbrains.annotations.NotNull;

public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.MHolder> {

    private Context context;
    private String[] titles;
    private int[] imgs;

    public ServerAdapter(Context context, String[] titles, int[] imgs){
        this.context = context;
        this.titles = titles;
        this.imgs = imgs;
    }

    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_home_server, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {

        String title = titles[position];

        int img = imgs[position];

        holder.img.setImageResource(img);

        holder.title.setText(title);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }

}
