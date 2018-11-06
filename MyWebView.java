package com.exmaple.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MyWebView extends WebView {
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode mode=super.startActionMode(callback);
        return selfMenu(mode);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        ActionMode mode=super.startActionMode(callback,type);
        return selfMenu(mode);
    }

    private ActionMode selfMenu(ActionMode mode){
        if(mode!=null){
            Menu menu=mode.getMenu();
            MenuItem item=menu.getItem(3);


        }
        return mode;
    }
}
