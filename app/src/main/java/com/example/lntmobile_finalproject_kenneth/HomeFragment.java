package com.example.lntmobile_finalproject_kenneth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        addFragment(view);
        return view;

    }

    private void addFragment(View view) {
        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager=view.findViewById(R.id.viewPager);
        FragmentAdapter adapter=new FragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new CounterFragment(), "Counter");
        adapter.addFragment(new AreaFragment(), "Area");
        adapter.addFragment(new VolumeFragment(), "Volume");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}