package ir.malv.detfgit.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import ir.malv.detfgit.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add fonts
        // Handle orientation
        // .etc
    }

    /**
     * TO show toast instead of calling a long method, Simply say toast("...");
     * @param message is the message you want to show
     */
    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * To set toolbar give your id to this one.
     * @param toolbarId is the ID e.g. -> R.id.toolbar
     */
    protected void toolbar(@IdRes int toolbarId) {
        setSupportActionBar((Toolbar) findViewById(toolbarId));
    }


    /**
     * If you don't want to use different id and all are toolbar simply use
     * The overloaded version of {@link #toolbar(int)}
     */
    protected void setDefaultToolbar() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    protected void simpleAlert(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show();
    }

}
