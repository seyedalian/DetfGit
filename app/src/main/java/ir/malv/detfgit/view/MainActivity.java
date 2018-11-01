package ir.malv.detfgit.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ir.malv.detfgit.R;
import ir.malv.detfgit.network.model.Enclosure;
import ir.malv.detfgit.network.model.Item;
import ir.malv.detfgit.network.model.Rss;
import ir.malv.detfgit.network.provider.DataProvider;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    DataProvider dataProvider;
    Rss rss;
    List<Item> items;
    ListView listNews;
    ItemAdapter adapter;
    TextView title;
    TextView link;
    TextView lastBuildDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultToolbar();
        init();
        //setOnClickListener for go to page of api
        link.setOnClickListener(this);






    }
    private void refreshDisplay() {
        adapter = new ItemAdapter(MainActivity.this,R.layout.item_of_listview,items);
        listNews.setAdapter(adapter);

    }




    private void init() {
        items = new ArrayList<>();
        dataProvider = DataProvider.getInstance();
        listNews =findViewById(R.id.list_View);
        title = findViewById(R.id.titleOfMainPage);
        link = findViewById(R.id.linkOfMain);
        lastBuildDate = findViewById(R.id.lastBuildDate);

        rss = dataProvider.getRss();

        if(rss != null){
            items=rss.getChannel().getItem();
            refreshDisplay();
            title.setText(rss.getChannel().getTitle());
            link.setText("go to page");
            lastBuildDate.setText(rss.getChannel().getLastBuildDate());
            String linkPage = rss.getChannel().getLink();
            link.setTag(linkPage);
        }





        // ...
    }



    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.linkOfMain){
            String uri =view.getTag().toString();
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(myIntent);
        }
    }





}
