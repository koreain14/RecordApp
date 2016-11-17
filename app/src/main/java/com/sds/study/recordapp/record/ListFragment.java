package com.sds.study.recordapp.record;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 파일 목록을 보여줄 프레그먼트!!
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{
    String TAG;

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;

    String fileName;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list,null);
        TAG=this.getClass().getName();

        listView=(ListView) view.findViewById(R.id.listView);
        list=(ArrayList) getFiles();

        adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        /*리스트뷰와 리스너 연결*/
        listView.setOnItemClickListener(this);

        return view;
    }

    /*외부 저장소인 iot_record 디렉토리의 모든 파일을 가져오자!!*/
    public List getFiles(){
        File file=new File(Environment.getExternalStorageDirectory(),"iot_record");
        File[] files=file.listFiles();

        ArrayList list = new ArrayList();

        for(int i=0;i<files.length;i++){
            list.add(files[i].getName());
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
        TextView txt=(TextView)view;
        fileName=txt.getText().toString();

        Toast.makeText(getContext(),"파일명은?"+fileName,Toast.LENGTH_SHORT).show();

        /*
            뷰페이저 중 index1(두번째 페이지에 해당하는)에 해당하는 DetailFragment 보여주기
        */
        FileListActivity fileListActivity=(FileListActivity) getContext();
        Log.d(TAG,"fileListActivity:"+fileListActivity);

        fileListActivity.viewPager.setCurrentItem(1);// 페이지 전환
    }
}
