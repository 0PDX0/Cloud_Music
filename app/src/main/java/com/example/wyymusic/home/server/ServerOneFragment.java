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

public class ServerOneFragment extends Fragment {

    private String[] titles = {"每日推荐", "私人漫游", "歌单", "排行榜", "有声书"};
    private int[] imgs = {R.mipmap.wyy_server_one, R.mipmap.wyy_server_two, R.mipmap.wyy_server_three, R.mipmap.wyy_server_four, R.mipmap.wyy_server_five};

    private FragmentHomeServerBinding binding;

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



















