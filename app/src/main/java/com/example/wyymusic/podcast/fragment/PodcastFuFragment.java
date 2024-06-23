package com.example.wyymusic.podcast.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;
import com.example.wyymusic.bean.MusicFm;
import com.example.wyymusic.bean.SongListBean;
import com.example.wyymusic.databinding.FragmentPodcastFuBinding;
import com.example.wyymusic.home.server.adapter.SongListAdapter;
import com.example.wyymusic.podcast.fragment.adapter.PodcastFmAdapter;
import com.example.wyymusic.podcast.fragment.adapter.PodcastServerAdapter;
import com.example.wyymusic.util.HttpUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class PodcastFuFragment extends Fragment {

    private FragmentPodcastFuBinding binding;
    private String[] names = {"我的播客","全部分类","排行榜","助眠解压","有声书","广播电台"};
    private int[] imgs = {R.mipmap.podcast_one, R.mipmap.podcast_two, R.mipmap.podcast_three, R.mipmap.podcast_four,R.mipmap.podcast_five, R.mipmap.podcast_six};

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {

            if (msg.what == 0){

                List<MusicFm.DateDTO> list = (List<MusicFm.DateDTO>) msg.obj;

                binding.podcastFmRecyc.setAdapter(new PodcastFmAdapter(getContext(), list));

            }else if (msg.what == 1){

                List<SongListBean.DataDTO> list = (List<SongListBean.DataDTO>) msg.obj;

                binding.podcastGuessLike.setAdapter(new SongListAdapter(getContext(), list));

            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPodcastFuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化播客服务
        initPodcastServer();

        //初始化随心听FM
        initFm();

        //初始化猜你喜欢
        initGuessLike();
    }

    /**
     * 初始化猜你喜欢
     */
    private void initGuessLike() {

        binding.podcastGuessLike.setLayoutManager(new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false));

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/podcast/like", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {

                        List<SongListBean.DataDTO> list = new Gson().fromJson(json, SongListBean.class).getData();

                        Message message = new Message();
                        message.what = 1;
                        message.obj = list;

                        handler.sendMessage(message);

                    }
                });

            }
        }).start();

    }

    /**
     * 初始化随心听FM
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initFm() {

        //#F0EFEB 背景 ！ 标题文字 #7E6B2F  ！ 其他子 #BDC5AE
        binding.podcastFmRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/podcast/fm", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {

                        List<MusicFm.DateDTO> list = new Gson().fromJson(json, MusicFm.class).getData();

                        Message message = new Message();
                        message.what = 0;
                        message.obj = list;

                        handler.sendMessage(message);
                    }
                });
            }
        }).start();

    }

    /**
     * 初始化播客服务
     */
    private void initPodcastServer() {

        binding.podcastServer.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        binding.podcastServer.setAdapter(new PodcastServerAdapter(getContext(), names, imgs));

    }



}
