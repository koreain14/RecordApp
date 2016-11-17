package com.sds.study.recordapp.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
    ViewPager는 껍데기에 불과하므로 뷰페이저에 보여질 프래그먼트가 총 몇개고, 어떤 페이지를 보여줘야 할지를
    관리해주는 어댑터를 이용해야한다!!
 */

public class MyAdapter extends FragmentStatePagerAdapter{
    /*앱에서 사용할 프래그먼트를 준비해 놓자!!*/
    Fragment[] fragments=new Fragment[3];


    public MyAdapter(FragmentManager fm) {
        super(fm);

        fragments[0]=new FragmentA();
        fragments[1]=new FragmentB();
        fragments[2]=new FragmentC();
    }

    public int getCount() {
        return fragments.length;
    }

    /*
    몇페이지를 어디에 보여줄래?
    position 몇페이지!!
    */
    public Fragment getItem(int position) {
        return fragments[position];
    }
}
