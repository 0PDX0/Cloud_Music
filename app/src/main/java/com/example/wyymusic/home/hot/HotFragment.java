package com.example.wyymusic.home.hot;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.bean.HotMusicBean;
import com.example.wyymusic.databinding.FragmentHomeHotBinding;
import com.example.wyymusic.home.hot.adapter.HotAdapter;

import java.util.List;


public class HotFragment extends Fragment {

    private List<HotMusicBean.DataDTO> list;
    private static List<HotMusicBean.DataDTO> listCache;
    private FragmentHomeHotBinding binding;

    public HotFragment(){}

    public HotFragment(List<HotMusicBean.DataDTO> list){
        listCache = list;
        this.list = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeHotBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化热门音乐
        initRecyc();
    }

    /**
     * 初始化热门音乐
     */
    private void initRecyc() {

        binding.homeHotRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        if (list == null || list.size() < 1){
            binding.homeHotRecyc.setAdapter(new HotAdapter(getContext(), listCache));
        }else {
            binding.homeHotRecyc.setAdapter(new HotAdapter(getContext(), list));

        }

    }
}















