package ua.regin.badproduct.util.kotlin.backport;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

@EFragment
public class JavaFragment extends Fragment {

    @FragmentArg
    protected int fragmentArg;

    @AfterViews
    protected void afterViews() {
    }
}
