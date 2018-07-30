package com.example.a18679.mvptask.presenter;

import com.example.a18679.mvptask.model.Model;
import com.example.a18679.mvptask.view.BaseView;

public class BasePresenter<V extends BaseView, M extends Model> {
    private V mView;
    private M mModel;

    public void attachView(V view) {
        mView = view;
    }

    public void disAttachView() {
        mView = null;
    }

    public boolean checkView() {
        return mView == null ? false : true;
    }

    public V getView() {
        return mView;

    }
}
