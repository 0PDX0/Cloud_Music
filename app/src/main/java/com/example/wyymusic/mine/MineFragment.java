package com.example.wyymusic.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.wyymusic.R;
import com.example.wyymusic.databinding.FragmentMineBinding;
import com.example.wyymusic.mine.fragment.MineOneFragment;
import com.example.wyymusic.mine.fragment.MineThreeFragment;
import com.example.wyymusic.mine.fragment.MineTwoFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment {

    private FragmentMineBinding binding;
    private String[] tabs = {"音乐", "播客", "动态"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMineBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化TabLayout + ViewPager
        initTabPager();

        Glide.with(getContext()).load(R.mipmap.pdx).transform(new CircleCrop()).into(binding.avatar);
    }

    /**
     * 初始化TabLayout + ViewPager
     */
    private void initTabPager() {

//        binding.mineBodyTabLayout.addTab(binding.mineBodyTabLayout.newTab().setText("狠狠"));
//        binding.mineBodyTabLayout.addTab(binding.mineBodyTabLayout.newTab().setText("狠狠1"));
//        binding.mineBodyTabLayout.addTab(binding.mineBodyTabLayout.newTab().setText("狠狠2"));

        //
        List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new MineOneFragment());
            add(new MineTwoFragment());
            add(new MineThreeFragment());
        }};

        binding.mineBodyViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

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

        binding.mineBodyTabLayout.setupWithViewPager(binding.mineBodyViewPager);

    }


}






























