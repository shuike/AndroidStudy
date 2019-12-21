package com.skit.customview;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.skit.lib_common.base.BaseActivity;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/22.
 * PS:
 */
public class LayoutParamsActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main_activity);
        final View view = findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                params.leftMargin += 100;
                v.requestLayout();
                v.setLayoutParams(params);
            }
        });
    }
}
