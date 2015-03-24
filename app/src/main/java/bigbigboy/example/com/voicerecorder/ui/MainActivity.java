package bigbigboy.example.com.voicerecorder.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import bigbigboy.example.com.voicerecorder.R;
import bigbigboy.example.com.voicerecorder.adapter.RecyclerViewAdapter;
import bigbigboy.example.com.voicerecorder.bean.MessageBean;
import bigbigboy.example.com.voicerecorder.support.widget.XCardView;
import bigbigboy.example.com.voicerecorder.support.widget.XRecyclerView;


public class MainActivity extends BaseActivity implements RecyclerViewAdapter.OnRecyclerViewListener, XRecyclerView.ScollListener {
    int[] bgcolor = {android.R.color.white, android.R.color.holo_red_dark, android.R.color.black, android.R.color.holo_blue_bright, android.R.color.holo_orange_dark,
            android.R.color.holo_green_dark, android.R.color.holo_red_light, android.R.color.white, android.R.color.holo_red_dark, android.R.color.black, android.R.color.holo_blue_bright, android.R.color.holo_orange_dark,
            android.R.color.holo_green_dark, android.R.color.holo_red_light, android.R.color.white, android.R.color.holo_red_dark, android.R.color.black, android.R.color.holo_blue_bright, android.R.color.holo_orange_dark,
            android.R.color.holo_green_dark};
    XRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        // getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        recyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setScollListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(createTempAdapterData());
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);
    }


    private List<MessageBean> createTempAdapterData() {
        List<MessageBean> list = new ArrayList<MessageBean>();
        for (int i = 0; i < 20; i++) {
            list.add(new MessageBean("BigBigBoy" + i, "人生这段旅程，我们无法预知将会遇见的风景，只要真心去欣赏，一切都是美不可言.", "2015年3月22日", (long) 12, "", bgcolor[i]));

        }
        return list;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onItemClick(int position) {

        Log.d("onItemClick", "onItemClick" + position);
    }

    @Override
    public boolean onItemLongClick(int position) {
        Log.d("onItemLongClick", "onItemLongClick" + position);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.ny));

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    View index = null;

    @Override
    public void onScroll() {
        Log.d("onScroll", "onScroll");
        View view = recyclerView.getChildAt(0);
        int count = recyclerView.getChildCount();
        if (count > 3 && (view != index)) {
            Log.d("(view != index)", "(view != index)");
            index = view;
            Log.d("getChildCount()", "recyclerView.getChildCount()" + recyclerView.getChildCount());
            int color = ((XCardView) view.findViewById(R.id.messagecardview)).getCardBackgroundColor();
            Drawable drawable = new ColorDrawable(color);
            getSupportActionBar().setBackgroundDrawable(drawable);
            recyclerView.setBackgroundDrawable(drawable);

            // if (count > 3) {
            for (int it = 2; it < count; it++) {
                XCardView xCardView = (XCardView) recyclerView.getChildAt(it).findViewById(R.id.messagecardview);
                if (it > 2)
                    xCardView.setTempCardBackgroundColor(color);
                xCardView.invalidate();
            }
            //}
        }

    }
}
