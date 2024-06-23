package com.example.wyymusic.home.radar.adapter;

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

public class RadarAdapter extends RecyclerView.Adapter<RadarAdapter.MHolder> {

    private Context context;

    private List<SongListBean.DataDTO> list;

    public RadarAdapter(Context context, List<SongListBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_home_radar, parent, false));
    }

    @Override
    public void onBindViewHolder(MHolder holder, int position) {

        SongListBean.DataDTO data = list.get(position);

        Glide.with(context).load(data.getImgUrl()).transform(new CenterCrop(), new RoundedCorners(15))
                .into(holder.img);

        holder.play_sum.setText(data.getPlaySum());

        holder.type.setText(data.getType());

        holder.content.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        private TextView play_sum;

        private TextView type;

        private TextView content;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            play_sum = itemView.findViewById(R.id.play_sum);
            type = itemView.findViewById(R.id.type);
            content = itemView.findViewById(R.id.content);
        }
    }

}
