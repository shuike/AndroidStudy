package com.skit.customview;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.skit.highcodeview.CodeView;
import com.skit.lib_common.base.BaseActivity;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/25.
 * PS:
 */
public class CodeViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_code_view);
        CodeView codeView = findViewById(R.id.codeview);
        codeView.fill().setCode("[\n" +
                "  {\n" +
                "    \"title\": \"apples\",\n" +
                "    \"count\": [12000, 20000],\n" +
                "    \"description\": {\"text\": \"...\", \"sensitive\": false}\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"oranges\",\n" +
                "    \"count\": [17500, null],\n" +
                "    \"description\": {\"text\": \"...\", \"sensitive\": false}\n" +
                "  }\n" +
                "]");

    }
}
