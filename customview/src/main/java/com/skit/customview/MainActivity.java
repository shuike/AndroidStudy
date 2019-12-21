package com.skit.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.skit.lib_common.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/21.
 * PS:
 */

@Route(path = "/view/main")
public class MainActivity extends BaseActivity {
    String[] groups = {"View的滑动", "自定义View"};
    String[][] values = {
            {
                    "scrollTo/scrollBy",
                    "View动画",
                    "属性动画",
                    "改变布局参数",
            },
            {
                    "ViewMeasure",
                    "跟随手指移动的View",
            },
    };
    Class[][] classes = {
            {
                    ViewScrollActivity.class,
                    ViewAnimationActivity.class,
                    ObjectAnimatorActivity.class,
                    LayoutParamsActivity.class
            },
            {
                    ViewMeasureActivity.class,
                    TouchViewActivity.class
            }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.expandable_list_content);
        ExpandableListView listView = findViewById(android.R.id.list);

        final List<Map<String, String>> group = new ArrayList<>();
        List<List<Map<String, String>>> childs = new ArrayList<>();
        for (int i = 0; i < groups.length; i++) {
            //提供父列表的数据
            Map<String, String> maps = new HashMap<String, String>();
            // maps.put("images", images[i]);
            maps.put("gname", groups[i]);
            group.add(maps);
            //提供当前父列的子列数据
            List<Map<String, String>> child = new ArrayList<Map<String, String>>();
            for (int j = 0; j < values[i].length; j++) {
                Map<String, String> mapsj = new HashMap<String, String>();
                mapsj.put("cname", values[i][j]);
                child.add(mapsj);
            }
            childs.add(child);
        }

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, group, android.R.layout.simple_expandable_list_item_1, new String[]{"gname"}, new int[]{android.R.id.text1}, childs, android.R.layout.simple_expandable_list_item_1, new String[]{"cname"}, new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(MainActivity.this, classes[groupPosition][childPosition]);
                startActivity(intent);
                return false;
            }
        });
    }

}
