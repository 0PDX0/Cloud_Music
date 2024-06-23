package com.example.wyymusic.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.wyymusic.R;
import com.example.wyymusic.community.fragment.CommunityFragmentOne;
import com.example.wyymusic.community.fragment.CommunityFragmentThree;
import com.example.wyymusic.community.fragment.CommunityFragmentTwo;
import com.example.wyymusic.databinding.FragmentCommunityBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    private FragmentCommunityBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommunityBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] names = {"广场", "视频", "歌房"};

        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new CommunityFragmentOne());
            add(new CommunityFragmentTwo());
            add(new CommunityFragmentThree());
        }};

        binding.communityViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
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

        binding.communityTabLayout.setupWithViewPager(binding.communityViewPager);
    }


}
















