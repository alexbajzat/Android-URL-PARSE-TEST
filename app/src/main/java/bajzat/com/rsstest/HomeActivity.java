package bajzat.com.rsstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bajzat.com.rsstest.backend.HandleXml;

public class HomeActivity extends AppCompatActivity {

    TextView title;
    TextView link;
    TextView description;
    Button rssButton;
    Button sourceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        title = (TextView) findViewById(R.id.home_title);
        link = (TextView) findViewById(R.id.home_link);
        description = (TextView) findViewById(R.id.home_description);
        rssButton = (Button) findViewById(R.id.home_rss_button);
        sourceButton = (Button) findViewById(R.id.home_source_button);

        sourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HomeActivity.this, SourceActivity.class);
                startActivity(in);
            }
        });

        rssButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doXmlStuff();
            }
        });
    }




    void doXmlStuff() {
        HandleXml obj = new HandleXml(getString(R.string.home_url_to_example));
        obj.fetchXML();

        while (obj.parsingComplete) ;
        title.setText(obj.getTitle());
        link.setText(obj.getLink());
        description.setText(obj.getDescription());
    }


}
