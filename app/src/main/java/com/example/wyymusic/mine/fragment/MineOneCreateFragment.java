package com.example.wyymusic.mine.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;
import com.example.wyymusic.bean.MineSongListBean;
import com.example.wyymusic.databinding.FragmentMineOneBinding;
import com.example.wyymusic.databinding.FragmentMineOneCreateBinding;
import com.example.wyymusic.mine.adapter.MineOneRecentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MineOneCreateFragment extends Fragment {

    private FragmentMineOneCreateBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMineOneCreateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化创建歌单
        initCreateRecyc();
    }

    private void initCreateRecyc() {

        List<MineSongListBean.DataDTO> list = new ArrayList<MineSongListBean.DataDTO>(){{
            add(new MineSongListBean.DataDTO(R.mipmap.create_song_list_one,"我喜欢的音乐","89首·1607次播放",1));
            add(new MineSongListBean.DataDTO(R.mipmap.create_song_list_two,"经典单","27首·117次播放·派大星",0));
            add(new MineSongListBean.DataDTO(R.mipmap.create_song_list_four,"新建歌单","",0));
            add(new MineSongListBean.DataDTO(R.mipmap.create_song_list_five,"导入外部歌单","轻松导入其他APP里的歌单",0));
        }};

        binding.mineOneCreateRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        binding.mineOneCreateRecyc.setAdapter(new MineOneRecentAdapter(getContext(), list));


    }


}



























