package com.example.wyymusic.home.hot.adapter;

import android.content.Context;
import android.util.Log;
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
import com.example.wyymusic.bean.HotMusicBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.MHolder>{

    private Context context;

    private List<HotMusicBean.DataDTO> list;

    public HotAdapter(Context context, List<HotMusicBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_home_hot, parent, false));
    }

    @Override
    public void onBindViewHolder(MHolder holder, int position) {

        HotMusicBean.DataDTO data = list.get(position);

        Glide.with(context).load(data.getImgUrl()).transform(new CenterCrop(), new RoundedCorners(15))
                .into(holder.img);

        holder.song_name.setText(data.getMusicName());

        holder.sing_name.setText(data.getName());

        if (position == 0){

            holder.is_hot.setVisibility(View.VISIBLE);

        }else if(position == 1){

            holder.is_hot.setVisibility(View.VISIBLE);
            holder.is_hot.setText("超过23%人收藏 >");

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        private TextView song_name;

        private TextView is_hot;

        private TextView sing_name;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);

            song_name = itemView.findViewById(R.id.song_name);

            is_hot = itemView.findViewById(R.id.is_hot);

            sing_name = itemView.findViewById(R.id.sing_name);
        }
    }

}
