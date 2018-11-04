package ir.malv.detfgit.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
    Typeface typeface;
    ImageView refreshIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultToolbar();
        init();
        //setOnClickListener for go to page of api
        link.setOnClickListener(this);
        refreshIV.setOnClickListener(this);




    }
    private void refreshDisplay() {
        adapter = new ItemAdapter(MainActivity.this,R.layout.item_of_listview,items,typeface);
        listNews.setAdapter(adapter);

    }





    private void init() {
        typeface = Typeface.createFromAsset(MainActivity.this.getAssets(),"fonts/bnazanin.ttf");
        items = new ArrayList<>();
        dataProvider = DataProvider.getInstance();
        listNews =findViewById(R.id.list_View);
        title = findViewById(R.id.titleOfMainPage);
        link = findViewById(R.id.linkOfMain);
        link.setTag("https://www.yjc.ir");
        lastBuildDate = findViewById(R.id.lastBuildDate);
        refreshIV = findViewById(R.id.refreshIV);
        //set typeFace for edit fonts
        title.setTypeface(typeface);
        link.setTypeface(typeface);
        lastBuildDate.setTypeface(typeface);


        if(isNetworkConnected()) {
            refreshConnect();

        }else {

            simpleAlert("توجه","اتصال اینترنت قطع می باشد",R.drawable.warnning);
        }


        // ...
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem refreshItemMenu = menu.add("").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                refreshConnect();
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        refreshItemMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        refreshItemMenu.setIcon(R.drawable.refresh);



        return super.onCreateOptionsMenu(menu);
    }

    private void refreshConnect() {
        dataProvider = new DataProvider();
        //add handel Because get information of Rss was delayed one second and dialog
        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("بارگیری اطلاعات");
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rss = dataProvider.getRss();
                if (rss != null) {
                    dialog.dismiss();
                    Log.i(Constant.APP_NAME, "rss not null");
                    items = rss.getChannel().getItem();
                    //refresh listView Display
                    refreshDisplay();
                    //set rss information in title and link and lastBuildDate
                    // title.setText(rss.getChannel().getTitle());
                    // link.setText("go to page");
                    lastBuildDate.setText(rss.getChannel().getLastBuildDate());
                    String linkPage = rss.getChannel().getLink();
                    link.setTag(linkPage);
                } else {
                    Log.e(Constant.APP_NAME, "null Rss");
                }
            }
        }, 1000l);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(rss==null){
                    dialog.dismiss();
                    simpleAlert("توجه","گرفتن اطلاعات با شکست مواجه شد",R.drawable.warnning);
                    refreshIV.setVisibility(View.VISIBLE);
                }
            }
        },2500l);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.linkOfMain){
            String uri =view.getTag().toString();
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(myIntent);
        }
        if(view.getId()==R.id.refreshIV){
            refreshConnect();
            refreshIV.setVisibility(View.GONE);

        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }



}
