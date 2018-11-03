package ir.malv.detfgit.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ir.malv.detfgit.Constant;
import ir.malv.detfgit.R;
import ir.malv.detfgit.network.model.Enclosure;
import ir.malv.detfgit.network.model.Item;
import ir.malv.detfgit.network.model.Rss;
import ir.malv.detfgit.network.provider.DataProvider;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    DataProvider dataProvider;
    Rss rss=null;
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
        //add handel Because get information of Rss was delayed one second
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rss =dataProvider.getRss();
                if(rss != null){
                    Log.i(Constant.APP_NAME,"rss not null");
                    items=rss.getChannel().getItem();
                    //refresh listView Display
                    //refreshDisplay();
                    //set rss information in title and link and lastBuildDate
                    title.setText(rss.getChannel().getTitle());
                    link.setText("go to page");
                    lastBuildDate.setText(rss.getChannel().getLastBuildDate());
                    String linkPage = rss.getChannel().getLink();
                    link.setTag(linkPage);
                }else {
                    Log.e(Constant.APP_NAME,"null Rss");
                }
            }
        },1000l);








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
