package com.nativereactstudy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by xiaoconglau on 10/08/2017.
 */

public class NativeWebviewActivity extends Activity {

    WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.native_webview_activity);
        webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);

        // This makes the layout/page rendering independent of the devices.
        // I use this to display local HTML pages.
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        this.webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }
        });


        this.webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);

            }
        });
        webview.loadUrl("http://172.28.1.29:8082/web-tab/");
    }

    public void openWholeReact(View view) {
        Intent intent = new Intent(this, SimpleReactActivity.class);
        startActivity(intent);
    }

    public void openMultiple(View view) {
        Intent intent = new Intent(this, MultipleActivity.class);
        startActivity(intent);
    }
}
