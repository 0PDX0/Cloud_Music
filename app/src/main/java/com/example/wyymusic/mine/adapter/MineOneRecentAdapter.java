package com.example.wyymusic.mine.adapter;

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
import com.example.wyymusic.bean.MineSongListBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MineOneRecentAdapter extends RecyclerView.Adapter<MineOneRecentAdapter.MHolder> {

    private Context context;
    private List<MineSongListBean.DataDTO> list;

    public MineOneRecentAdapter(Context context, List<MineSongListBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_one_recent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MHolder holder, int position) {

        MineSongListBean.DataDTO data = list.get(position);

        if (data.getIsLove() == 1){
            holder.love_img.setVisibility(View.VISIBLE);
            holder.love_img1.setVisibility(View.VISIBLE);
        }

        if (data.getContent().equals("") || data.getContent() == null){
            holder.content.setVisibility(View.GONE);
        }

        Glide.with(context).load(data.getImgUrl()).transform(new CenterCrop(),new RoundedCorners(20))
                .into(holder.img);

        holder.name.setText(data.getName());

        holder.content.setText(data.getContent());

        if (list.size() == 4){
            if (position == 1){
                holder.more.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder {

        private ImageView img;

        private ImageView love_img;

        private TextView name;

        private TextView content;

        private ImageView love_img1;

        private ImageView more;


        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            love_img = itemView.findViewById(R.id.love_img);
            name = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            love_img1 = itemView.findViewById(R.id.love_img1);
            more = itemView.findViewById(R.id.more);
        }
    }

}
