package com.exmaple.web;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * 长按 复制、全选、分享、百度搜索新页面打开
 * https://github.com/CarGuo/CustomActionWebView
 */
public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button s;
    EditText http;
    WebSettings webSettings;
    boolean js=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.web);
        s=findViewById(R.id.speed);
        http=findViewById(R.id.http);
        webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(false);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if(savedInstanceState==null)
            webView.loadUrl("https://www.baidu.com");
        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    //点击返回上一页面而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (webView!=null){
            webView.destroy();
            webView=null;
        }
        super.onDestroy();
    }

    public void speed(View view) {
        if(js){
            js=false;
            s.setText("K");
        }else{
            js=true;
            s.setText("M");
        }
        webSettings.setJavaScriptEnabled(js);
        webView.reload();
    }

    public void next(View view) {
        if(webView.canGoForward())
            webView.goForward();
    }

    public void new_page(View view) {
        Intent intent = new Intent(getApplication(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(intent);
    }

    public void run(View view) {

    }
}
