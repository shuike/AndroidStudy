package com.skit.customview;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;

import com.skit.lib_common.base.BaseActivity;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/22.
 * PS:
 */
public class ViewAnimationActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main_activity);
        final View view = findViewById(R.id.view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ViewAnimationActivity.this,R.anim.view_translate);
                view.setAnimation(animation);
                view.startAnimation(animation);
            }
        });
    }
}
