package com.example.wyymusic.follow.adapter;

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
import com.example.wyymusic.bean.TrendBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FollowNews1Adapter extends RecyclerView.Adapter<FollowNews1Adapter.MHolder> {

    private Context context;
    private List<TrendBean.DataDTO> list;

    public FollowNews1Adapter(Context context, List<TrendBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_follow_two_recyc, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MHolder holder, int position) {

        TrendBean.DataDTO data = list.get(position);

        Glide.with(context).load(data.getImgUrl())
                .into(holder.img);

        if (position != 2){
            holder.img1.setVisibility(View.GONE);
        }

        holder.name.setText(data.getName());

        holder.time.setText(data.getTime());

        holder.content.setText(data.getContent());

        Glide.with(context).load(data.getMusicPath()).transform(new CenterCrop(), new RoundedCorners(10))
                .into(holder.music_img);

        holder.music_name.setText(data.getMusicName());

        holder.sing_name.setText(data.getSingName());

        holder.share_number.setText(data.getShareNumber());

        holder.comment_number.setText(data.getCommentNumber());

        holder.like_number.setText(data.getLikeNumber());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        private TextView name;

        private TextView time;

        private TextView content;

        private ImageView music_img;

        private TextView music_name;

        private TextView sing_name;

        private TextView share_number;

        private TextView comment_number;

        private TextView like_number;

        private ImageView img1;

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);

            name = itemView.findViewById(R.id.name);

            time = itemView.findViewById(R.id.time);

            content = itemView.findViewById(R.id.content);

            music_img = itemView.findViewById(R.id.music_img);

            music_name = itemView.findViewById(R.id.music_name);

            sing_name = itemView.findViewById(R.id.sing_name);

            share_number = itemView.findViewById(R.id.share_number);

            comment_number = itemView.findViewById(R.id.comment_number);

            like_number = itemView.findViewById(R.id.like_number);

            img1 = itemView.findViewById(R.id.img1);
        }
    }

}
