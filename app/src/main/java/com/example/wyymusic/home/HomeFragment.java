package com.example.wyymusic.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.wyymusic.App;
import com.example.wyymusic.MainActivity;
import com.example.wyymusic.R;
import com.example.wyymusic.bean.BannerBean;
import com.example.wyymusic.bean.HotMusicBean;
import com.example.wyymusic.bean.SongListBean;
import com.example.wyymusic.databinding.FragmentHomeBinding;
import com.example.wyymusic.home.hot.HotFragment;
import com.example.wyymusic.home.radar.adapter.RadarAdapter;
import com.example.wyymusic.home.server.ServerOneFragment;
import com.example.wyymusic.home.server.ServerTwoFragment;
import com.example.wyymusic.home.server.adapter.SongListAdapter;
import com.example.wyymusic.util.HttpUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.HttpUrl;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private Handler handler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {

            if (msg.what == 0){

                //初始化推荐歌单
                List<SongListBean.DataDTO> list = (List<SongListBean.DataDTO>) msg.obj;

                binding.recommendSingList.setAdapter(new SongListAdapter(getContext(), list));

            }else if (msg.what == 1){

                //初始化推荐音乐
                List<HotMusicBean.DataDTO> list = (List<HotMusicBean.DataDTO>) msg.obj;

                HotFragment hotFragmentOne = new HotFragment(list.subList(0, 3));
                HotFragment hotFragmentTwo = new HotFragment(list.subList(3, 6));
                HotFragment hotFragmentThree = new HotFragment(list.subList(6, 9));

                List<Fragment> fragmentList = new ArrayList<Fragment>(){{
                    add(hotFragmentOne);
                    add(hotFragmentTwo);
                    add(hotFragmentThree);
                }};

                binding.recommendViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
                    @NonNull
                    @NotNull
                    @Override
                    public Fragment getItem(int position) {
                        return fragmentList.get(position);
                    }

                    @Override
                    public int getCount() {
                        return fragmentList.size();
                    }
                });


            }else if (msg.what == 2){

                //初始化雷达歌单
                List<SongListBean.DataDTO> list = (List<SongListBean.DataDTO>) msg.obj;
                binding.radarSingListRecyc.setAdapter(new RadarAdapter(getActivity(), list));

            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {        //TODO 设置状态栏为亮色模式(这会自动将字体变为黑色)
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化搜索框
        initSearch();

        //初始化主页顶部的工具栏
        initTopTab();

        //初始化轮播图
        initBanner();

        //初始化服务
        initServer();

        //初始化推荐歌单
        initSingList();

        //初始化热门信息，随时刷新
        initHotMusic();

        //初始化雷达歌单
        initRadarPlayList();

    }

    /**
     * 初始化搜索框
     */
    private void initSearch() {

        binding.topSearch.clearFocus();

        binding.topSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    startActivity(new Intent(getActivity(), SearchDetialActivity.class));
//                    binding.topSearch.clearFocus();
                }
            }
        });

    }

    /**
     * 初始化雷达歌单
     */
    private void initRadarPlayList() {

        binding.radarSingListRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

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

                                Message message = new Message();
                                message.obj = list;
                                message.what = 2;

                                handler.sendMessage(message);

                            }
                        });

//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                binding.radarSingListRecyc.setAdapter(new RadarAdapter(getActivity(), list));
//
//                            }
//                        });

                    }
                });

            }
        }).start();

    }

    /**
     * 初始化热门歌曲信息
     */
    private void initHotMusic() {

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/home/hotmusic", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {

                        List<HotMusicBean.DataDTO> list = new Gson().fromJson(json, HotMusicBean.class).getData();

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = 1;
                                message.obj = list;

                                handler.sendMessage(message);

                            }
                        });

//                        HotFragment hotFragmentOne = new HotFragment(list.subList(0, 3));
//                        HotFragment hotFragmentTwo = new HotFragment(list.subList(3, 6));
//                        HotFragment hotFragmentThree = new HotFragment(list.subList(6, 9));
//
//                        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
//                            add(hotFragmentOne);
//                            add(hotFragmentTwo);
//                            add(hotFragmentThree);
//                        }};
//
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                binding.recommendViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
//                                    @NonNull
//                                    @NotNull
//                                    @Override
//                                    public Fragment getItem(int position) {
//                                        return fragmentList.get(position);
//                                    }
//
//                                    @Override
//                                    public int getCount() {
//                                        return fragmentList.size();
//                                    }
//                                });
//                            }
//                        });

                    }
                });

            }
        }).start();



    }

    /**
     * 初始化推荐歌单
     */
    private void initSingList() {

        binding.recommendSingList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/home/songlist", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {

                        List<SongListBean.DataDTO> data = new Gson().fromJson(json, SongListBean.class).getData();

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = 0;
                                message.obj = data;

                                handler.sendMessage(message);
                            }
                        });

//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                binding.recommendSingList.setAdapter(new SongListAdapter(getContext(), data));
//                            }
//                        });

                    }
                });

            }
        }).start();

    }

    /**
     * 初始化服务 (TabLayout + ViewPager)
     * TODO 注意这个地方又出现了ViewPager,因为现在是在滚动视图中，ViewPager的高度是无法自动计算的，需要用户设置固定高度
     */
    private void initServer() {

        ServerOneFragment serverOneFragment = new ServerOneFragment();
        ServerTwoFragment serverTwoFragment = new ServerTwoFragment();

        //
        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(serverOneFragment);
            add(serverTwoFragment);
        }};

        //
        binding.homeServerViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @NonNull
            @NotNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        binding.homeServerTabLayout.setupWithViewPager(binding.homeServerViewPager);

        for (int i = 0; i < binding.homeServerTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = binding.homeServerTabLayout.getTabAt(i);
            tab.setCustomView(getView(i));
        }



    }

    /**
     * 初始化轮播图
     */
    private void initBanner() {

        binding.bannerLl.setBackground(App.showGradual1("#FFFFFF", "#F0F0FC", "#F7E5F3"));

        //发起网络请求，获取轮播图片
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {

                HttpUtil.getMap("http://192.168.1.69:8080/home/banner", new HashMap<>(), new HttpUtil.onRequest() {
                    @Override
                    public void onRequest(String json) {
                        List<String> bannerList = new Gson().fromJson(json, BannerBean.class).getData();

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                                //设置轮播图片
                                binding.homeBanner.setAdapter(new BannerImageAdapter<String>(bannerList) {
                                    @Override
                                    public void onBindView(BannerImageHolder bannerImageHolder, String s, int i, int i1) {
                                        Glide.with(getContext()).load(s).transform(new CenterCrop()).into(bannerImageHolder.imageView);
                                    }
                                });

                                //设置轮播小点
                                binding.homeBanner.setIndicator(new CircleIndicator(getContext()));

                                //设置轮播圆角
                                binding.homeBanner.setBannerRound(25);
                            }
                        });
                    }
                });

            }
        }).start();



    }

    /**
     * 初始化主页顶部的工具栏
     */
    private void initTopTab() {
        //设置主页上部分的渐变效果
        binding.topLl.setBackground(App.showGradual1("#F8F7FC", "#F0F0FC", "#F7E5F3"));

    }

    /**
     * 初始化主页推荐服务的TabLayout的小条
     * @param position
     */
    public View getView(int position){
        View view = View.inflate(getContext(), R.layout.item_home_server_tab, null);

        View v = view.findViewById(R.id.v);

        if (position == 0){
            v.setBackgroundColor(Color.parseColor("#F0261C"));
        }else {
            v.setBackgroundColor(Color.parseColor("#747474"));
        }

        return view;
    }
}





























