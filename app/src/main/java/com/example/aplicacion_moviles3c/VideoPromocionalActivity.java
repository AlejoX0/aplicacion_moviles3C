package com.example.aplicacion_moviles3c;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPromocionalActivity extends AppCompatActivity {

    private static final String VIDEO_ID = "ysz5S6PUM-U";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_promocional);

        webView = findViewById(R.id.webViewVideo);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String html = "<html><body style='margin:0;padding:0;background-color:#0F172A'>" +
                "<iframe width='100%' height='100%' src='https://www.youtube.com/embed/" + VIDEO_ID +
                "' frameborder='0' allowfullscreen></iframe></body></html>";
        webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);

        NavigationHelper.setupMenuButton(this);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }
}
