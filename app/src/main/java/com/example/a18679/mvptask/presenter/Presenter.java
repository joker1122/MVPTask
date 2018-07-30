package com.example.a18679.mvptask.presenter;

import com.example.a18679.mvptask.model.Model;
import com.example.a18679.mvptask.view.MvpView;

public class Presenter extends BasePresenter<MvpView, Model> {

    public Presenter() {
    }

    public void changeHeight() {
        if (checkView()) {
            getView().changeHeight();
        }
    }

    public void changeWidth() {
        if (checkView()) {
            getView().changeWidth();
        }
    }
}
