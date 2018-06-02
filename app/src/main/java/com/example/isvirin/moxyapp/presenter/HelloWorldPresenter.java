package com.example.isvirin.moxyapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.isvirin.moxyapp.model.GreetingGenerator;
import com.example.isvirin.moxyapp.view.HelloWorldView;

@InjectViewState
public class HelloWorldPresenter extends MvpPresenter<HelloWorldView> {
    private GreetingGenerator greetingGenerator;

    private void cancelGreetingTaskIfRunning() {
        if (greetingGenerator != null) {
            greetingGenerator.cancel(true);
        }
    }

    public void generateHello() {
        cancelGreetingTaskIfRunning();
        greetingGenerator = new GreetingGenerator("Hello", new GreetingGenerator.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String generatedString) {
                getViewState().showHello(generatedString);
            }
        });
        greetingGenerator.execute();
    }

    public void generateBye() {
        cancelGreetingTaskIfRunning();
        greetingGenerator = new GreetingGenerator("GoodBye", new GreetingGenerator.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String generatedString) {
                getViewState().showGoodBye(generatedString);
            }
        });
        greetingGenerator.execute();
    }
}
