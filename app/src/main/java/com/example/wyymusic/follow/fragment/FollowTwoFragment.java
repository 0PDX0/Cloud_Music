package com.example.wyymusic.follow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.wyymusic.R;
import com.example.wyymusic.bean.TrendBean;
import com.example.wyymusic.databinding.FragmentFollowTwoBinding;
import com.example.wyymusic.follow.adapter.FollowNews1Adapter;
import com.example.wyymusic.follow.adapter.FollowNewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FollowTwoFragment extends Fragment {

    private FragmentFollowTwoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFollowTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(getContext()).load(R.mipmap.hj).transform(new CenterCrop(), new RoundedCorners(15))
                .into(binding.cs);

        Glide.with(getContext()).load(R.mipmap.guangg_one).transform(new CircleCrop())
                .into(binding.cs1);

        Glide.with(getContext()).load(R.mipmap.guangg_three).transform(new CenterCrop(), new RoundedCorners(40))
                .into(binding.cs2);

        //初始化朋友动态
        initFriendRecyc();
    }

    /**
     * 初始化朋友动态
     */
    private void initFriendRecyc() {

        List<TrendBean.DataDTO> list = new ArrayList<TrendBean.DataDTO>(){{
            add(new TrendBean.DataDTO(R.mipmap.user_one,"DR_CYP","你红心歌曲有精彩动态了","渐行渐远。我只能做到不拖累了\n对不起，我可能做不到你想要的吧","http://p1.music.126.net/wSMfGvFzOAYRU_yVIfquAA==/2946691248081599.jpg?param=130y130","凄美地","郭顶","2","9","45"));
            add(new TrendBean.DataDTO(R.mipmap.user_two,"一口Echokk","38粉丝","和大伙儿在一起的快乐\n没有办法一直同行的大家\n但也要好好享受每一刻在一起的快乐和小\n确幸补","http://p2.music.126.net/UGRApZC93gTHsB5hyJyGoA==/109951165107814694.jpg?param=130y130","晚霞","Kryust","10","89","355"));
            add(new TrendBean.DataDTO(R.mipmap.user_three,"律研子","3985粉丝","非常感谢网易云音乐平台欣赏推存","http://p2.music.126.net/q92Vk1Y1OWUS_ZjsYm1hjw==/1408474407901371.jpg?param=130y130","最好地安排","曲婉莹","79","678","6799"));
            add(new TrendBean.DataDTO(R.mipmap.user_four ,"多么虚幻_","歌手华晨宇的热歌有新讨论!","他竟然跟我说 加油!!!\n一定要加油!!\n赶上他!!","http://p1.music.126.net/lFZwmPiCmHRr-d5_5o0iLw==/109951169159410322.jpg?param=130y130","For Forever","华晨宇","30","89","998"));
        }};

        binding.followTwoRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        binding.followTwoRecyc.setAdapter(new FollowNews1Adapter(getContext(), list));


    }


}





























