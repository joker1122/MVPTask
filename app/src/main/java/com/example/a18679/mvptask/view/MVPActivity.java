package com.example.a18679.mvptask.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a18679.mvptask.R;
import com.example.a18679.mvptask.adapter.TaskAdapter;
import com.example.a18679.mvptask.presenter.Presenter;
import com.example.a18679.mvptask.ui.UiTask;
import com.example.a18679.mvptask.ui.ClickListener;
import com.example.greendao.GreenDAO;

import java.util.ArrayList;
import java.util.List;


public class MVPActivity extends AppCompatActivity implements View.OnClickListener, MvpView, AbsListView.OnScrollListener {
    private Button mButtonHeight;
    private Button mButtonWidth;
    private UiTask mUiTask;
    private ListView mListView;
    private List<String> mStringArrayList;
    private Presenter mPresenter;
    private TaskAdapter mTaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        init();
    }

    private void init() {
        GreenDAO greenDAO = new GreenDAO();
        mUiTask = (UiTask) findViewById(R.id.ui_task);
        mUiTask.addOnClickListener(new ClickListener() {
            @Override
            public void leftClick(View view) {
                Toast.makeText(MVPActivity.this, "leftClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick(View view) {
                Toast.makeText(MVPActivity.this, "rightClick", Toast.LENGTH_SHORT).show();
            }
        });
        mListView = (ListView) findViewById(R.id.lv_lv);
        mListView.setEmptyView(findViewById(R.id.task));
        mListView.setOnScrollListener(this);
        initArrayList(30);
        mTaskAdapter = new TaskAdapter(this, mStringArrayList);
        mListView.setAdapter(mTaskAdapter);
        mButtonHeight = (Button) findViewById(R.id.bt_change_height);
        mButtonWidth = (Button) findViewById(R.id.bt_change_width);
        mButtonWidth.setOnClickListener(this);
        mButtonHeight.setOnClickListener(this);
        mPresenter = new Presenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_change_height:
                mPresenter.changeHeight();
                break;
            case R.id.bt_change_width:
                mPresenter.changeWidth();
                break;
            default:
                break;
        }
    }

    @Override
    public void changeHeight() {
        Toast.makeText(this, "height had changed", Toast.LENGTH_LONG).show();
//        mListView.smoothScrollBy(100, 2000);
        mListView.smoothScrollToPosition(mTaskAdapter.getCount());
    }

    @Override
    public void changeWidth() {
        Toast.makeText(this, "width had changed", Toast.LENGTH_LONG).show();
        mListView.layout(mListView.getLeft() + 100, mListView.getTop(), mListView.getLeft() + mListView.getWidth(), mListView.getTop() + mListView.getHeight());
    }

    @Override
    public void get() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }

    private void initArrayList(int num) {
        mStringArrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            mStringArrayList.add("item__" + i);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                Toast.makeText(this, "SCROLL_STATE_IDLE", Toast.LENGTH_LONG).show();
                break;
            case SCROLL_STATE_FLING:
                Toast.makeText(this, "SCROLL_STATE_FLING", Toast.LENGTH_LONG).show();
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Toast.makeText(this, "SCROLL_STATE_TOUCH_SCROLL", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
