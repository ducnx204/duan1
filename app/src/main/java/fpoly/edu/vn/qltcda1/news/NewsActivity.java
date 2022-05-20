package fpoly.edu.vn.qltcda1.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fpoly.edu.vn.qltcda1.Adapter.RSSAdapter;
import fpoly.edu.vn.qltcda1.R;
import fpoly.edu.vn.qltcda1.model.RSS;
import fpoly.edu.vn.qltcda1.model.XMLDOMParser;

public class NewsActivity extends AppCompatActivity {
    ListView lv_item;
    RSSAdapter rssAdapter;
    ArrayList<RSS> rssModels;
    private TextView tvTitle;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        lv_item = findViewById(R.id.list_item);

        setTitleToolbar();
        rssModels = new ArrayList<>();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new RssFeed().execute("https://vtc.vn/rss/feed.rss");
            }
        });

        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewsActivity.this, LoadWedActivity.class);
                intent.putExtra("link",rssModels.get(position).getLink());
                startActivity(intent);

            }
        });
    }

    private void setTitleToolbar() {

        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Tin tức");

    }

    public class RssFeed extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            return ReadContent(strings[0]);
        }
        @Override
        protected void onPostExecute(String s) {

            XMLDOMParser xmldomParser = new XMLDOMParser();
            try {
                Document document
                        = xmldomParser.getDocument(s);

                NodeList nodeList = document.getElementsByTagName("item");
                NodeList nodeListdescription = document.getElementsByTagName("description");
                String title = "";
                String link = "";
                String image = "";


                for (int i = 0; i < nodeList.getLength(); i++) {
                    String cData = nodeListdescription.item(i + 1).getTextContent();
                    Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");

                    Matcher matcher
                            = p.matcher(cData);
                    if (matcher.find()) {
                        image = matcher.group(1);
                    }
                    Element element = (Element) nodeList.item(i);
                    title = xmldomParser.getValue(element, "title");
                    link = xmldomParser.getValue(element, "link");
                    rssModels.add(new RSS(title, image, link));
                }
                rssAdapter = new RSSAdapter(NewsActivity.this, android.R.layout.simple_list_item_1, rssModels);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }

            lv_item.setAdapter(rssAdapter);
            super.onPostExecute(s);
        }

        private String ReadContent(String theUrl) {
            StringBuilder content = new StringBuilder();
            try {

                URL url = new URL(theUrl);

                URLConnection urlConnection = url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                Log.d("content", content.toString());
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return content.toString();
        }




    }
}