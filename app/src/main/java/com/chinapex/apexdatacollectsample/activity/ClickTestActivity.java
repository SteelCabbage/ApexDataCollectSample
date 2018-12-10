package com.chinapex.apexdatacollectsample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;


import com.chinapex.apexdatacollectsample.R;
import com.chinapex.apexdatacollectsample.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Seven
 * @date : 2018/11/28
 */
public class ClickTestActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final String TAG = ClickTestActivity.class.getSimpleName();

    private ListView mListView;
    private GridView mGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_test);

        initView();
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                AppLog.i(TAG, "开始游戏");
                break;
            case R.id.over:
                AppLog.i(TAG, "结束游戏");
                break;
            case R.id.setting1:
                AppLog.i(TAG, "声音設置");
                break;
            case R.id.setting2:
                AppLog.i(TAG, "背景設置");
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_button:
                AppLog.i(TAG, "onClick ImageButton is clicked !!!");
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent instanceof GridView) {
            AppLog.i(TAG, "mGridView item is clicked !!!  position: " + position);
            return;
        }

        if (parent instanceof ListView) {
            AppLog.i(TAG, "mListView item is clicked !!!  position: " + position);
        }
    }

    public void xmlOnClick(View view) {
        switch (view.getId()) {
            case R.id.clickable_text:
                AppLog.i(TAG, "xmlOnClick Text is clicked !!!");
                break;
            case R.id.clickable_image_view:
                AppLog.i(TAG, "xmlOnClick ImageView is clicked !!!");
                break;
            default:
                break;
        }
    }

    private void initView() {
        mListView = findViewById(R.id.list_view);
        mGridView = findViewById(R.id.grid_view);
        ImageButton imageButton = findViewById(R.id.image_button);

        imageButton.setOnClickListener(this);
        mGridView.setOnItemClickListener(this);
        mListView.setOnItemClickListener(this);
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }

        mListView.setAdapter(new ArrayAdapter<>(this, R.layout.list_view_item, R.id.list_view_item_text, list));
        mGridView.setAdapter(new ArrayAdapter<>(this, R.layout.list_view_item, R.id.list_view_item_text, list));
    }

}
