package com.example.wyymusic.home.server;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;
import com.example.wyymusic.databinding.FragmentHomeServerBinding;
import com.example.wyymusic.home.server.adapter.ServerAdapter;

public class ServerTwoFragment extends Fragment {

    private FragmentHomeServerBinding binding;

    private String[] titles = {"直播", "关注新歌", "妙时", "收藏家", "歌房"};
    private int[] imgs = {R.mipmap.wyy_server_six, R.mipmap.wyy_server_seven, R.mipmap.wyy_server_eight, R.mipmap.wyy_server_nine, R.mipmap.wyy_server_ten};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeServerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeServerRecyc.setLayoutManager(new GridLayoutManager(getContext(), 5, RecyclerView.VERTICAL, false));

        binding.homeServerRecyc.setAdapter(new ServerAdapter(getContext(), titles, imgs ));

    }



}
