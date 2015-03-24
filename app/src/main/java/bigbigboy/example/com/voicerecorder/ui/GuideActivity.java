package bigbigboy.example.com.voicerecorder.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import bigbigboy.example.com.voicerecorder.R;
import bigbigboy.example.com.voicerecorder.adapter.GuideFragmentPagerAdapter;

/**
 * @ClassName: GuideActivity
 * @Description: TODO 引导页
 */
public class GuideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private final String TAG = this.getClass().getName();
    private ViewPager viewPager;
    /**
     * 引导页图片的资源ID，导航页将根据他的长度生成对应的适配器与标志
     */
    private int[] guidepicPics_ResId = {R.mipmap.guidepic7, R.mipmap.guidepic5,
            R.mipmap.guidepic6};
    /**
     * 当前导航页位置标志
     */
    private LinearLayout indicateLayout;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //去除title
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.guidePages);
        indicateLayout = (LinearLayout) findViewById(R.id.indicateGroup);
        initIndicateLayout(guidepicPics_ResId.length);
        viewPager.setAdapter(new GuideFragmentPagerAdapter(guidepicPics_ResId, getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(this);

    }

    /**
     * 根据引导页图片数量自动生成进度标志
     *
     * @param picNum 引导页图片数量
     */
    public void initIndicateLayout(int picNum) {
        for (int i = 0; i < picNum; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.thumb_indicate_iv);
            iv.setPadding(8, 8, 8, 8);
            if (i == 0)
                iv.setSelected(true);
            indicateLayout.addView(iv, i);
        }
    }

    //记录导航页上一次位置
    int oldPosition;

    /**
     * 不管左滑右滑，将位置更大的那一个标志状态取反
     *
     * @param position 当前所在页面位置
     */
    @Override
    public void onPageSelected(int position) {
        View view = indicateLayout.getChildAt((oldPosition > position) ? oldPosition : position);
        view.setSelected(!view.isSelected());
        oldPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /*
    public void toMainActivity(View v) {
        SaveIsOpen(true);
        Intent intent = new Intent();
        intent.setClass(GuideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void SaveIsOpen(boolean IsOpen) {
        MySharedPreferences.SaveIsOpen(IsOpen, getApplicationContext());
    }*/
}