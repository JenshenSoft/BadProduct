package ua.regin.badproduct.ui;

import android.os.Bundle;

import com.trello.rxlifecycle.components.support.RxFragment;

public abstract class BaseFragment extends RxFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectComponent();
    }

    protected abstract void injectComponent();
}
