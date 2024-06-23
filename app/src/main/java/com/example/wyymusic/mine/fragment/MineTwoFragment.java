package com.example.wyymusic.mine.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.wyymusic.R;
import com.example.wyymusic.bean.SongListBean;
import com.example.wyymusic.databinding.FragmentMineTwoBinding;
import com.example.wyymusic.home.server.adapter.SongListAdapter;
import com.example.wyymusic.mine.adapter.SongListAdapter1;
import com.example.wyymusic.util.HttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class MineTwoFragment extends Fragment {

    private FragmentMineTwoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMineTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Glide.with(getContext()).load(R.mipmap.create_song_list_four).transform(new CenterCrop(), new RoundedCorners(20))
                .into(binding.img);


        //初始化为你推荐
        binding.mineTwoRecyc.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/home/radarPlayList", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {

                        List<SongListBean.DataDTO> list = new Gson().fromJson(json, SongListBean.class).getData();

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.mineTwoRecyc.setAdapter(new SongListAdapter1(getContext(), list));
                            }
                        });
                    }
                });

            }
        }).start();
    }


}
















