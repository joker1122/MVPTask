package com.example.a18679.mvptask.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a18679.mvptask.view.MvpView;

public class BaseFragment extends Fragment implements MvpView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void changeHeight() {

    }

    @Override
    public void changeWidth() {

    }

    @Override
    public void get() {

    }
}
