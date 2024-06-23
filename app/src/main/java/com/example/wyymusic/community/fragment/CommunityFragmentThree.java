package com.example.wyymusic.community.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.wyymusic.databinding.FragmentCommunityBinding;
import com.example.wyymusic.databinding.FragmentCommunityThreeBinding;

public class CommunityFragmentThree extends Fragment {

    private FragmentCommunityThreeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCommunityThreeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }


}
















