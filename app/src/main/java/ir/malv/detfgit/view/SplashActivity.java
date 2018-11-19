package ir.malv.detfgit.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ir.malv.detfgit.R;

public class SplashActivity extends BaseActivity {
    TextView textInSplash;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Typeface typeface = Typeface.createFromAsset(SplashActivity.this.getAssets(),"fonts/bnazanin.ttf");
        textInSplash =findViewById(R.id.textInSplash);
        textInSplash.setTypeface(typeface);
        imageView = findViewById(R.id.sp_icon_main);
        imageView.setAlpha(0f);
        imageView.animate().alpha(1f).setDuration(2000l).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();



            }
        },3000l);



    }
}
