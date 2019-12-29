package com.skit.highcodeview;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/25.
 * PS:
 */
public enum CodeViewTheme {
    DEFAULT("androidstudio","#282b2e");
    String name;
    String background;
    CodeViewTheme(String name, String background) {
        this.name = name;
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
