package ua.regin.badproduct.ui;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle.components.support.RxFragment

abstract class BaseFragment : RxFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getResId(), container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        injectComponent();
        afterViews();
    }

    abstract fun injectComponent();
    abstract fun getResId(): Int;
    abstract fun afterViews();
}

