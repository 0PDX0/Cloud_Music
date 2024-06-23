package com.example.wyymusic.podcast;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.wyymusic.App;
import com.example.wyymusic.R;
import com.example.wyymusic.databinding.FragmentPodcastBinding;
import com.example.wyymusic.podcast.fragment.AudioBookFragment;
import com.example.wyymusic.podcast.fragment.HearingFragment;
import com.example.wyymusic.podcast.fragment.PodcastFuFragment;
import com.example.wyymusic.podcast.fragment.RadioDramaFragment;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PodcastFragment extends Fragment {

    private FragmentPodcastBinding binding;
    private String[] titles = {"播客","有声书","广播剧","听听"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPodcastBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO 设置状态栏为亮色模式(这会自动将字体变为黑色)
        App.setStatusBckColor(getActivity());
        //TODO 这个设置的状态栏的颜色必须使用 color.xml 中定义的颜色,这里将他设置为白色
        App.setStatusBarColor(getActivity(), R.color.red);


        //初始化顶部TabLayout
        initTopTabLayout();
    }

    /**
     * 初始化顶部TabLayout
     */
    private void initTopTabLayout() {

//        binding.podcastTopTabLayout.addTab(binding.podcastTopTabLayout.newTab().setText("素质"));
//        binding.podcastTopTabLayout.addTab(binding.podcastTopTabLayout.newTab().setText("素质1"));
//        binding.podcastTopTabLayout.addTab(binding.podcastTopTabLayout.newTab().setText("素质2"));
//        binding.podcastTopTabLayout.addTab(binding.podcastTopTabLayout.newTab().setText("素质3"));

        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new PodcastFuFragment());
            add(new AudioBookFragment());
            add(new RadioDramaFragment());
            add(new HearingFragment());
        }};

        binding.podcastViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }


            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        binding.podcastTopTabLayout.setupWithViewPager(binding.podcastViewPager);

    }


}













