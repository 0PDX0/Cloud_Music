package com.example.wyymusic.mine.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.wyymusic.R;
import com.example.wyymusic.databinding.FragmentMineOneBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MineOneFragment extends Fragment {

    private FragmentMineOneBinding binding;
    private String[] tabs = {"近期","创建"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMineOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化TabLayout + ViewPager
        initTabPager();
    }

    /**
     * 初始化TabLayout + ViewPager
     */
    private void initTabPager() {

        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new MineOneRecentFragment());
            add(new MineOneCreateFragment());
        }};

        binding.mineOneViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

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
                return tabs[position];
            }
        });

        binding.mineOneTabLayout.setupWithViewPager(binding.mineOneViewPager);

    }


}



























