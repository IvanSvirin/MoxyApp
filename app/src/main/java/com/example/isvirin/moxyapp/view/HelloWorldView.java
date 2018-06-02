package com.example.isvirin.moxyapp.view;

import com.arellomobile.mvp.MvpView;

public interface HelloWorldView extends MvpView {
    void showHello(String helloTxt);

    void showGoodBye(String byeTxt);
}
