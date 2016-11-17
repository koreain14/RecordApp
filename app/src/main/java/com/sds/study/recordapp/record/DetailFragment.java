package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.util.List;

public class DetailFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*페이지를 구성하는 나 아닌 다른 페이지 프레그먼트를 접근해보자*/

        FragmentManager manager=this.getFragmentManager();
        List<Fragment> list= manager.getFragments();
        ListFragment fragment =(ListFragment) list.get(0);

        Toast.makeText(getContext(),"fileName은?"+fragment.fileName,Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_detail,null);
    }
}
