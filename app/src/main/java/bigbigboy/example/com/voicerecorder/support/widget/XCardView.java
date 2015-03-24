package bigbigboy.example.com.voicerecorder.support.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by BigBigBoy on 2015/3/24.
 */
public class XCardView extends CardView {


    public XCardView(Context context) {
        super(context);
    }

    public XCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setCardBackgroundColor(int color) {
        super.setCardBackgroundColor(color);
        this.cardBackgroundColor = color;
    }

    public int getCardBackgroundColor() {
        return cardBackgroundColor;
    }

    int cardBackgroundColor;
    //tempColor不能用-1，因为白色的时候出错，这里取最大值
    int tempColor =0x7FFFFFFF;

    public void setTempCardBackgroundColor(int color) {
        this.tempColor = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void invalidate() {
        if (tempColor != 0x7FFFFFFF) {
            super.setCardBackgroundColor(tempColor);
            tempColor = 0x7FFFFFFF;
        } else {
            setCardBackgroundColor(getCardBackgroundColor());
        }
        super.invalidate();
    }
}
