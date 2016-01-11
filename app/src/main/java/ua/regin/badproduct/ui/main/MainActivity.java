package ua.regin.badproduct.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.EActivity;

import ua.regin.badproduct.R;
import ua.regin.badproduct.ui.BaseActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Fragment fragment = MainFragment_.builder().build();
            switchFragment(fragment);
        }
    }

    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, fragment)
                .commit();
    }
}
