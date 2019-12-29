package com.skit.highcodeview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/12/25.
 * PS:
 */
public class CodeView extends WebView {
    CodeViewTheme theme;
    private static final String BASE_HTML=
            "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\t<script src=\"file:///android_asset/highlight/highlight.pack.js\"></script>\n" +
                    "\t<script>hljs.initHighlightingOnLoad();</script>\n" +
                    "\t<title></title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</body>\n" +
                    "</html>";
    private Document document;

    public CodeView(Context context) {
        this(context, null);
    }

    public CodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        theme = CodeViewTheme.DEFAULT;
        getSettings().setJavaScriptEnabled(true);
    }

    public void setCode(String code){
        document = Jsoup.parse(BASE_HTML);
        document.head().after(style());
        document.body().appendElement("pre").appendElement("code").text(code);
//        loadData(document.html(),"text/html","utf-8");
        loadDataWithBaseURL("",document.html(),"text/html","utf-8","");
    }

    private String style() {
        return  "<link rel=\"stylesheet\" href=\"file:///android_asset/highlight/styles/"+theme.getName()+".css\"/>";
    }
    public CodeView fill(){
        setBackgroundColor(Color.parseColor(theme.getBackground()));
        return this;
    }
}
