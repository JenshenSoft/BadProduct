package ua.regin.badproduct.ui;

import android.os.Bundle
import android.view.*
import com.trello.rxlifecycle.components.support.RxFragment

abstract class BaseFragment : RxFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getResId(), container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        injectComponent();
        afterViews();
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(getOptionsId(), menu);
    }

    abstract fun getResId(): Int;
    abstract fun getOptionsId(): Int;

    open protected fun injectComponent() {
    }

    open protected fun afterViews() {
    }
}

