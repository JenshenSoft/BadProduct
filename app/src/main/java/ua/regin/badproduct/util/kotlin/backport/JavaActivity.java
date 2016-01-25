package ua.regin.badproduct.util.kotlin.backport;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity
public class JavaActivity extends AppCompatActivity {

    @ViewById
    protected View view;

    @AfterViews
    protected void afterViews() {
    }

    @Bean
    protected JavaBean javaBean;
}
