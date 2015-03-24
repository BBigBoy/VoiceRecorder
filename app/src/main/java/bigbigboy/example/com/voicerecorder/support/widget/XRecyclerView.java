package bigbigboy.example.com.voicerecorder.support.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by BigBigBoy on 2015/3/24.
 */
public class XRecyclerView extends RecyclerView {
    public ScollListener getScollListener() {
        return scollListener;
    }

    public void setScollListener(ScollListener scollListener) {
        this.scollListener = scollListener;
    }

    ScollListener scollListener;
    public interface ScollListener {
        public void onScroll();
    }

    public XRecyclerView(Context context) {
        super(context);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scollListener!=null)
            scollListener.onScroll();
    }
}
