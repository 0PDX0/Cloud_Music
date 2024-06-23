package com.example.wyymusic.follow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wyymusic.R;
import com.example.wyymusic.bean.TrendBean;
import com.example.wyymusic.databinding.FragmentFollowOneBinding;
import com.example.wyymusic.follow.adapter.FollowNewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FollowOneFragment extends Fragment {

    private FragmentFollowOneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFollowOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化全部动态
        initAllTrend();

    }

    /**
     * 初始化全部动态
     */
    private void initAllTrend() {

        List<TrendBean.DataDTO> list = new ArrayList<TrendBean.DataDTO>(){{
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","昨天18:10","R.E.M.乐队作品的独特感真强，首专就有些颠覆了当时的音乐模式。无论是嗓音还是歌词都很神秘，让这张另类摇滚专辑非常抓人的耳朵。","http://p2.music.126.net/gsbhT9RQSl36l4AxdojZog==/109951167013527891.jpg?param=130y130","Murmur(Deluxe)","R.E.M.","9","45","243"));
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","1月17日","波兰钢琴大师Krystian Zimerman来华演出了。最近重温了下他演奏的肖邦叙事曲，深沉温暖的琴声，把肖邦作品的浪漫诠释得很彻底。在现场听一定会有更非凡的感受吧！","http://p2.music.126.net/O_mdq1l_-Ln9G9i6I0TbBw==/109951166108848294.jpg?param=130y130","Chopin: 4 Ballades","Krystian","5","23","113"));
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","1月16日","迪斯科鼻祖Boney M.这首热情，活力的歌曲感染力好强，真是首百听不厌的经典老歌。曲子一响起来，完全就是70年代人的回忆。","http://p1.music.126.net/xHARa-ORV1ZrLRiKstxGKg==/5741649720332175.jpg?param=130y130","Rivers Of Babylon","Roney M.","45","115","1198"));
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","1月15日","Steve Earle的首张专辑让人惊喜，欢快的吉他很有吸引力。纯正的乡村音乐里加了摇滚元素，软硬结合的风格很奇妙，在当时给其他乡村音乐家带来了不少灵感。","http://p2.music.126.net/Kqn2Sba8jdZEAL62o_qc9Q==/6624557558276914.jpg?param=130y130","Guitar Town","Steve Earle","7","35","556"));
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","1月14日","Soft Machine以这张专辑为由头，从迷幻摇滚逐渐转向了爵士摇滚。歌曲的制作及开头结尾的细节设计都很有创意性，各种元素的大杂烩也非常有冒险精神。","http://p1.music.126.net/voGuO9A0XJqeIVNlPuv5sA==/109951167934065836.jpg?param=130y130","Third","Project Moon","11","67","652"));
            add(new TrendBean.DataDTO(R.mipmap.follow_two,"网易CEO","1月13日","这是一张很能展现Elliott Smith音乐才华的专辑。美丽又忧郁的曲调让人着迷，歌曲的制作也非常精致。Elliott的歌词很有深度，能让听众找到生活里的共鸣。","http://p2.music.126.net/xDjWUxvTgb8u8Zs85ItP8g==/109951163571232151.jpg?param=130y130","Figure","Koven","56","267","4321"));
        }};

        binding.followOneRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        binding.followOneRecyc.setAdapter(new FollowNewsAdapter(getContext(), list));

    }




}
































