package ua.regin.badproduct.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import ua.regin.badproduct.R;
import ua.regin.badproduct.util.ThemeUtils;

public class CollapseLayout extends FrameLayout implements View.OnClickListener {

    private TextView titleView;
    private TextView collapseView;

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setTitle(@StringRes int titleId) {
        titleView.setText(titleId);
    }

    public void setCollapseText(String title) {
        collapseView.setText(title);
    }

    public void setCollapseText(@StringRes int collapsedId) {
        collapseView.setText(collapsedId);
    }

    public CollapseLayout(Context context) {
        super(context);
        init(context, null);
    }

    public CollapseLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CollapseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CollapseLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        inflate(context, R.layout.layout_collapse, this);
        setBackgroundResource(ThemeUtils.getResourceFromAttribute(context, R.attr.selectableItemBackgroundBorderless));
        setOnClickListener(this);
        titleView = (TextView) findViewById(R.id.titleView);
        collapseView = (TextView) findViewById(R.id.collapseView);
    }

    @Override
    public void onClick(View v) {
        if (titleView.getVisibility() == VISIBLE) {
            titleView.setVisibility(GONE);
            collapseView.setVisibility(VISIBLE);
        } else {
            titleView.setVisibility(VISIBLE);
            collapseView.setVisibility(GONE);
        }
    }
}
