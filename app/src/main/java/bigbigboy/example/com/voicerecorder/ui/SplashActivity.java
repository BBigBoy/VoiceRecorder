package bigbigboy.example.com.voicerecorder.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import bigbigboy.example.com.voicerecorder.R;

public class SplashActivity extends BaseActivity {

    private Handler mHandler = new Handler();

    private AnimatorSet animationSet = new AnimatorSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 判断程序若是首次启动，则进入引导页
       /* if (!MySharedPreferences.GetIsOpen(getApplicationContext())) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), GuideActivity.class);
            startActivity(intent);
            finish();
        }*/
        setContentView(R.layout.activity_start);

        TextView textView = (TextView) findViewById(R.id.textView1);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(textView,
                "alpha", 0.3f, 1.0f).setDuration(3000);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(textView,
                "scaleX", 0.3f, 1.0f).setDuration(3000);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(textView,
                "scaleY", 0.3f, 1.0f).setDuration(3000);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(textView,
                "rotationX", 0, 90).setDuration(1500);
        objectAnimator4.setStartDelay(1000);
        animationSet.play(objectAnimator1).with(objectAnimator2)
                .with(objectAnimator3);
        animationSet.play(objectAnimator4).after(objectAnimator3);

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        animationSet.start();

        mHandler.postDelayed((new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                toMainActivity();
            }
        }), 6000);
    }

    @Override
    public void onBackPressed() {
    }

    /**
     * 转到MainActivity
     */
    private void toMainActivity() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        super.finish();
    }

}
