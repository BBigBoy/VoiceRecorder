package bigbigboy.example.com.voicerecorder.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import bigbigboy.example.com.voicerecorder.support.utils.ActivityCollector;
import bigbigboy.example.com.voicerecorder.support.utils.Loger;

/**
 * Created by BigBigBoy on 2015/3/22.
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Loger.state(getClass().getSimpleName(), "------>onCreate");
        ActivityCollector.getInstance().addActivity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
        ActivityCollector.getInstance().finishActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Loger.state(getClass().getSimpleName(), "------>onCreate");
    }
}
