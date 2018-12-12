package com.chinapex.apexdatacollectsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chinapex.apexdatacollectsample.R;
import com.chinapex.apexdatacollectsample.SampleApp;
import com.chinapex.apexdatacollectsample.adapter.RvAdapter;
import com.chinapex.apexdatacollectsample.bean.Student;
import com.chinapex.apexdatacollectsample.utils.AppLog;

import java.util.ArrayList;

public class ListRvActivity extends AppCompatActivity implements RvAdapter.OnItemClickListener {

    private static final String TAG = ListRvActivity.class.getSimpleName();
    private RecyclerView mRv;
    private RvAdapter mRvAdapter;
    private ArrayList<Student> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);

        mRv.setLayoutManager(new LinearLayoutManager(SampleApp.getInstance(), LinearLayoutManager.VERTICAL, false));

        mDatas = new ArrayList<Student>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("姓名:" + i);
            student.setAge(i);
            mDatas.add(student);
        }

        mRvAdapter = new RvAdapter(mDatas);
        mRvAdapter.setOnItemClickListener(this);
        mRv.setAdapter(mRvAdapter);

//        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                AppLog.i(TAG, "onScrollStateChanged newState:" + newState);
//            }
//        });

    }

    @Override
    public void onItemClick(int position) {
        if (null == mDatas || mDatas.isEmpty()) {
            AppLog.e(TAG, "mDatas is null or empty!");
            return;
        }

        Student student = mDatas.get(position);
//        AppLog.i(TAG, "position:" + position + ", student:" + student);
    }
}
