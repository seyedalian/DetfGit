package ir.malv.detfgit.view;

import android.os.Bundle;

import ir.malv.detfgit.R;
import ir.malv.detfgit.network.provider.DataProvider;

public class MainActivity extends BaseActivity {

    DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultToolbar();
        initViews();


        //simpleAlert("title", "message");


    }

    /**
     * Initialize XML views.
     */
    private void initViews() {
        dataProvider = DataProvider.getInstance();
        // ...
    }
}
