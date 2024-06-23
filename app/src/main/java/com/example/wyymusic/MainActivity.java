package com.example.wyymusic;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.wyymusic.bean.MusicBean;
import com.example.wyymusic.bean.SearchWyyMusicBean;
import com.example.wyymusic.bean.WyyMusicBean;
import com.example.wyymusic.community.CommunityFragment;
import com.example.wyymusic.follow.FollowFragment;
import com.example.wyymusic.home.HomeFragment;
import com.example.wyymusic.mine.MineFragment;
import com.example.wyymusic.podcast.PodcastFragment;
import com.example.wyymusic.util.HttpUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager main_view_pager;
    private TabLayout main_tab_layout;
    private int[] imgNos = {R.mipmap.main_tab_one_no, R.mipmap.main_tab_two_no, R.mipmap.main_tab_three_no, R.mipmap.main_tab_four_no, R.mipmap.main_tab_five_no};
    private int[] imgSelects = {R.mipmap.main_tab_one_select, R.mipmap.main_tab_two_select, R.mipmap.main_tab_three_select, R.mipmap.main_tab_four_select, R.mipmap.main_tab_five_select};
    private String[] names = {"发现", "播客", "我的", "关注", "社区"};
    private static ImageView img;
    private static TextView music_name;
    private static TextView sing_name;
    private static ImageView play_is_stop;
    private static MediaPlayer mediaPlayer;
    public static String musicName;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 这个设置的状态栏的颜色必须使用 color.xml 中定义的颜色,这里将他设置为白色
//        App.setStatusBckColor(MainActivity.this);
//        App.setStatusBarColor(this, R.color.white);

        //初始化视图
        initView();

        //初始化ViewPager + TabLayout
        initViewPagerTab();

        ImageView music_img = findViewById(R.id.img);

        Glide.with(this).load(R.mipmap.qmd).transform(new CircleCrop()).into(music_img);
    }

    /**
     * 初始化ViewPager + TabLayout
     */
    private void initViewPagerTab() {

        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new HomeFragment());
            add(new PodcastFragment());
            add(new MineFragment());
            add(new FollowFragment());
            add(new CommunityFragment());
        }};

        main_view_pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        main_view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {

                //页面2有点特殊，我的界面上部分全为灰色
                if (position == 2){
                    App.setNavigationBckColor(MainActivity.this);
                    App.setStatusBarColor(MainActivity.this, R.color.gray);

                }else {
                    App.setStatusBckColor(MainActivity.this);
                    App.setStatusBarColor(MainActivity.this, R.color.white);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        main_tab_layout.setupWithViewPager(main_view_pager);

        for (int i = 0; i < main_tab_layout.getTabCount(); i++) {
            TabLayout.Tab tab = main_tab_layout.getTabAt(i);
            tab.setCustomView(getView(i));
        }

        main_tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();

                Glide.with(MainActivity.this).load(imgSelects[tab.getPosition()])
                        .transform(new CenterInside()).into((ImageView) customView.findViewById(R.id.img));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();

                Glide.with(MainActivity.this).load(imgNos[tab.getPosition()])
                        .transform(new CenterInside()).into((ImageView) customView.findViewById(R.id.img));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //#E8E6FC  #F7E5F3  //#D9DCFB  #F0D9F3
//        main_tab_layout.getTabAt(1).select();
//        main_tab_layout.getTabAt(0).select();
    }

    /**
     * 初始化视图
     */
    private void initView() {

        main_view_pager = findViewById(R.id.main_view_pager);

        main_tab_layout = findViewById(R.id.main_tab_layout);

        //
        img = findViewById(R.id.img);

        music_name = findViewById(R.id.music_name);

        sing_name = findViewById(R.id.sing_name);

        play_is_stop = findViewById(R.id.play_is_stop);
        play_is_stop.setTag("0");

        play_is_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (play_is_stop.getTag().toString().equals("1")){

                    //为1就代表当前为播放状态，将图片设置为可播放
                    play_is_stop.setImageResource(R.mipmap.play);
                    play_is_stop.setTag("0");

                    playRotate(false);
                    stopMusic();

                }else {

                    //为0就代表当前为暂停状态,将图片设置为可暂停
                    play_is_stop.setImageResource(R.mipmap.stop);
                    play_is_stop.setTag("1");

                    playRotate(true);
                    startMusic();

                }
            }
        });

        findViewById(R.id.cs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


//        new Thread(new Runnable() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void run() {
//                HttpUtil.getMap("http://music.cyrilstudio.top/search", new HashMap<String, Object>() {{
//                    put("keywords", "凄美地");
//                }}, new HttpUtil.onRequest() {
//                    @Override
//                    public void onRequest(String json) {
//                        WyyMusicBean.Result.Songs wyyMusicBean = new Gson().fromJson(json, WyyMusicBean.class).getResult().getSongs().get(0);
//
//                        Log.e("PDXWYY", wyyMusicBean.getId());
//
//                        /*--------*/
//
//                        HttpUtil.getMap("http://music.cyrilstudio.top/song/url", new HashMap<String, Object>() {{
//                            put("id", wyyMusicBean.getId());
//                        }}, new HttpUtil.onRequest() {
//                            @Override
//                            public void onRequest(String json) {
//
//                                SearchWyyMusicBean.DataDTO data = new Gson().fromJson(json, SearchWyyMusicBean.class).getData().get(0);
//
//                                Log.e("PDXWYYSEARCH", data.getUrl());
////                                playMusic(data.getUrl());
//
//                            }
//                        });
//
//                        /*--------*/
//
//                    }
//                });
//            }
//        }).start();

    }


    public View getView(int position){

        View view = View.inflate(this, R.layout.item_main_tab, null);

        ImageView img = view.findViewById(R.id.img);

        TextView name = view.findViewById(R.id.name);

        if (position == 0){
            Glide.with(this).load(imgSelects[position]).into(img);
        }else {
            Glide.with(this).load(imgNos[position]).into(img);
        }

        name.setText(names[position]);

        return view;
    }


    /**
     * 播放音乐
     * @param music
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void play(Context context, MusicBean music){

        Glide.with(context).load(music.getImgUrl()).transform(new CircleCrop())
                .into(img);

        music_name.setText(music.getMusicName());

        sing_name.setText(music.getSingName());

        if (play_is_stop.getTag().toString().equals("1")){

            //为1就代表当前为播放状态，将图片设置为可播放
            play_is_stop.setImageResource(R.mipmap.play);
            play_is_stop.setTag("0");

        }else {

            //为0就代表当前为暂停状态,将图片设置为可暂停
            play_is_stop.setImageResource(R.mipmap.stop);
            play_is_stop.setTag("1");

        }


    }


    /**
     * 开启媒体流
     */
    public static void playMusic(String path){

        if (mediaPlayer != null){
            mediaPlayer.reset();
        }else {

        }

        if (musicName != null){
            music_name.setText(musicName);
        }

        //创建MediaPlayer对象
        mediaPlayer = new MediaPlayer();

        //设置音频流类型
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());

        try {

            //设置数据源
            mediaPlayer.setDataSource(path);

            //准备播放
            mediaPlayer.prepareAsync();

        } catch (IOException e){
            e.printStackTrace();
        }

        //设置准备完成监听器
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //开始播放
                mediaPlayer.start();

                //设置正在播放的图片
                play_is_stop.setImageResource(R.mipmap.stop);
                play_is_stop.setTag("1");

                //设置图片旋转
                playRotate(true);
            }
        });
    }

    /**
     * 暂停媒体流
     */
    public static void stopMusic(){

        if (mediaPlayer != null){
            mediaPlayer.pause();
        }

    }

    /**
     * 播放媒体流
     */
    public static void startMusic(){

        if (mediaPlayer != null){
            mediaPlayer.start();
        }

    }

    private static Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 图片旋转
     */
    public static void playRotate(Boolean is){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                img.setRotation(img.getRotation() + 1);

                Log.e("PDX", "run");

                handler.postDelayed(this, 50);
            }
        };

        if (is){
            handler.postDelayed(runnable, 1);
        }else {
            handler.removeMessages(0);
            handler.removeCallbacks(runnable);
        }

    }

    /**
     * 释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null){
            mediaPlayer.release();
        }
    }
}






















