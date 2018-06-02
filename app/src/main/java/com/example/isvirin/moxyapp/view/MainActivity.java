package com.example.isvirin.moxyapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.viewstate.MvpViewState;
import com.example.isvirin.moxyapp.R;
import com.example.isvirin.moxyapp.presenter.HelloWorldPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements HelloWorldView {
    @BindView(R.id.textViewHelloBye)
    TextView textViewHelloBye;

    @InjectPresenter
    HelloWorldPresenter helloWorldPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonHello)
    public void onButtonHelloClicked() {
        helloWorldPresenter.generateHello();
    }

    @OnClick(R.id.buttonBye)
    public void onButtonByeClicked() {
        helloWorldPresenter.generateBye();
    }

    @Override
    public void showHello(String helloTxt) {
        textViewHelloBye.setText(helloTxt);
    }

    @Override
    public void showGoodBye(String byeTxt) {
        textViewHelloBye.setText(byeTxt);
    }
}


