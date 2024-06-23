package com.example.wyymusic.home.server.adapter;

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
import com.example.wyymusic.bean.SongListBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.MHolder> {

    private Context context;

    private List<SongListBean.DataDTO> list;

    public SongListAdapter(Context context, List<SongListBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_sing_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MHolder holder, int position) {

        SongListBean.DataDTO data = list.get(position);

        Glide.with(context).load(data.getImgUrl()).transform(new CenterCrop(), new RoundedCorners(25))
                .into(holder.img);

        holder.playSum.setText(data.getPlaySum());

        holder.content.setText(data.getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MHolder extends RecyclerView.ViewHolder {

        private ImageView img;

        private TextView playSum;

        private TextView content;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);

            playSum = itemView.findViewById(R.id.play_sum);

            content = itemView.findViewById(R.id.content);
        }
    }

}


















