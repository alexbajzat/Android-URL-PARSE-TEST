package bajzat.com.rsstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import bajzat.com.rsstest.R;

public class SourceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        WebView webPage= (WebView) findViewById(R.id.source_web_view);
        webPage.loadUrl(getString(R.string.home_url_to_example));

    }
}
