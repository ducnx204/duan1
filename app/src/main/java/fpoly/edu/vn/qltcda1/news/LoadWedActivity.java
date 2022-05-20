package fpoly.edu.vn.qltcda1.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import fpoly.edu.vn.qltcda1.R;

public class LoadWedActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_wed);
        webView = findViewById(R.id.wedView);
        Intent intent = getIntent();
        String linkURL = intent.getStringExtra("link");
        webView.loadUrl(linkURL);
        webView.setWebViewClient(new WebViewClient());

    }
}