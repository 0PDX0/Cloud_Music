package com.example.wyymusic.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.wyymusic.bean.CommunityBean;
import com.example.wyymusic.databinding.ItemCommunityOneBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommunityOneAdapter extends RecyclerView.Adapter<CommunityOneAdapter.MHolder> {

    private Context context;
    private ItemCommunityOneBinding binding;
    private List<CommunityBean.DataDTO> list;

    public CommunityOneAdapter(Context context, List<CommunityBean.DataDTO> list){
        this.context = context;
        this.list = list;
    }


    @Override
    public MHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemCommunityOneBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MHolder holder, int position) {

        CommunityBean.DataDTO data = list.get(position);

        if (data.getImg1() == null || data.getImg1().equals("")){

            binding.card.setVisibility(View.GONE);
        }else {

            Glide.with(context).load(data.getImg1()).into(binding.img1);
            Glide.with(context).load(data.getImg2()).into(binding.img2);
        }

        if (data.getType() == null || data.getType().equals("")){

            binding.type.setVisibility(View.GONE);
        }else {

            binding.type.setText(data.getType());
        }

        if (position == 2){
         binding.vip.setVisibility(View.GONE);
        }

        /////
        Glide.with(context).load(data.getUserImgUrl()).transform(new CircleCrop()).into(binding.img);

        binding.name.setText(data.getUserName());

        binding.content.setText(data.getContent());

        Glide.with(context).load(data.getMusicPath()).transform(new CenterCrop(), new RoundedCorners(15)).into(binding.musicImg);

        binding.musicName.setText(data.getMusicName());

        binding.singName.setText(data.getSingName());

        binding.shareNumber.setText(data.getShareNumber());

        binding.commentNumber.setText(data.getCommentNumber());

        binding.likeNumber.setText(data.getLikeNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MHolder extends RecyclerView.ViewHolder {

        public MHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }





}
