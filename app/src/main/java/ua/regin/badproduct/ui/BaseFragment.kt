package ua.regin.badproduct.ui;

import android.os.Bundle
import android.view.*
import com.trello.rxlifecycle.components.support.RxFragment

abstract class BaseFragment : RxFragment() {

    private val HAS_NO_MENU: Int = -1;

    private var optionsId: Int = HAS_NO_MENU


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        optionsId = getOptionsId();
        setHasOptionsMenu(optionsId != HAS_NO_MENU)
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
        if (optionsId != HAS_NO_MENU) {
            inflater?.inflate(optionsId, menu);
        }
    }

    abstract fun getResId(): Int;
    open protected fun getOptionsId() = HAS_NO_MENU;
    open protected fun injectComponent() = Unit
    open protected fun afterViews() = Unit
}

