package ir.malv.detfgit.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ir.malv.detfgit.R;

public class SplashActivity extends BaseActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Typeface typeface = Typeface.createFromAsset(SplashActivity.this.getAssets(),"fonts/bnazanin.ttf");
        textView =findViewById(R.id.textView);
        textView.setTypeface(typeface);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();



            }
        },2500l);



    }
}
