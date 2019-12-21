package com.skit.customview;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.skit.lib_common.base.BaseActivity;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/22.
 * PS:
 */
public class MyViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_myview);
    }
}
