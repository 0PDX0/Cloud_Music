package com.example.wyymusic.follow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;
import com.example.wyymusic.databinding.FragmentFollowBinding;
import com.example.wyymusic.follow.fragment.FollowOneFragment;
import com.example.wyymusic.follow.fragment.FollowThreeFragment;
import com.example.wyymusic.follow.fragment.FollowTwoFragment;
import com.example.wyymusic.podcast.fragment.adapter.PodcastServerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FollowFragment extends Fragment {

    private FragmentFollowBinding binding;
    private String[] names = {"乐迷团", "网易CEO", "毛驴", "Koutaru", "全部好友"};
    private int[] imgs = {R.mipmap.follow_one, R.mipmap.follow_two, R.mipmap.follow_three, R.mipmap.follow_four, R.mipmap.follow_five};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFollowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化关注的人
        initFollowRecyc();

        //初始化我的关注全部动态
        initFollowTrends();
    }

    /**
     * 初始化我的关注全部动态
     */
    private void initFollowTrends() {

        String names[] = {"全部", "音乐人", "朋友"};

        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new FollowOneFragment());
            add(new FollowTwoFragment());
            add(new FollowThreeFragment());
        }};

        binding.followViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
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

            @Override
            public CharSequence getPageTitle(int position) {
                return names[position];
            }
        });

        binding.followTabLayout.setupWithViewPager(binding.followViewPager);

    }

    /**
     * 初始化关注的人
     */
    private void initFollowRecyc() {

        binding.followRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        binding.followRecyc.setAdapter(new PodcastServerAdapter(getContext(), names, imgs));

    }


}



























