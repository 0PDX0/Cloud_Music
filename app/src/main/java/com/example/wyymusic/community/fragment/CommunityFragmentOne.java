package com.example.wyymusic.community.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.bean.CommunityBean;
import com.example.wyymusic.community.adapter.CommunityOneAdapter;
import com.example.wyymusic.databinding.FragmentCommunityBinding;
import com.example.wyymusic.databinding.FragmentCommunityOneBinding;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragmentOne extends Fragment {

    private FragmentCommunityOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommunityOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.communityOneRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        List<CommunityBean.DataDTO> list = new ArrayList<CommunityBean.DataDTO>(){{
            add(new CommunityBean.DataDTO("http://p2.music.126.net/vD8v-AOJ1ZIVai-yrYnYWw==/109951169256148190.jpg?param=50y50","秋水与鱼","再也不再石家庄跨年了","http://sns-webpic-qc.xhscdn.com/202401192323/37399d9108a6462ae5863029a61158d5/1000g0082q4snaiajs0005o2bbbv0boio0k52bqo!nc_n_webp_mw_1","http://sns-webpic-qc.xhscdn.com/202401192315/54f8bc30e16527e423c04c1504ec7c04/1000g0082o45b7gkjm0505oo8t4a4g8g1spibkh0!nc_n_webp_mw_1","http://p2.music.126.net/7_58jxn4S4nzIs-D8nLQ5Q==/109951167578505822.jpg?param=130y130","再等冬天","h3R3","#闪闪发光的生活碎片","118","795","5578 "));
            add(new CommunityBean.DataDTO("http://p1.music.126.net/oUYX0QOxpZ8TDakFRRHMOg==/109951169248897593.jpg?param=50y50","小泽_HYWr","昨天和她分手啦，\n不是我提的，\n我也不是渣男。\n她16岁广东，我16岁陕西，\n这1488公里一个16岁的少年如何跨过去呢，我们是网恋是异地，怪我们相遇在了错误的时候","","","http://p1.music.126.net/kBBbMnsS9IIxoBlypXe_YQ==/109951168882711578.jpg?param=130y130","想你的夜","Dave","","67","376","2267"));
            add(new CommunityBean.DataDTO("http://p1.music.126.net/P4HGeLiOHUxfV6TpfC0Vvg==/109951167742925077.jpg?param=50y50","用户4896945217","13岁的时候\n我的女同桌喂了我一块饼干\n我吃完脸红了\n然后她笑着说地上捡的我说没关系","","","http://p1.music.126.net/14hYZBiJuo_hFTG5zBCDpg==/109951168166773206.jpg?param=130y130","珍惜才配拥有","琪总","","26","177","967"));
            add(new CommunityBean.DataDTO("http://p1.music.126.net/GZMcBcPk3s8_UOL6WbclwQ==/109951168548477059.jpg?param=50y50","与小郝","她会常提起故乡，说有神住在这里。","","","http://p2.music.126.net/ShUbqlPez9i2J_oSMz1ERw==/109951169260983232.jpg?param=130y130","圣山","LamaMaboo","","54","278","1782"));

        }};

        binding.communityOneRecyc.setAdapter(new CommunityOneAdapter(getContext(), list));

    }


}
















