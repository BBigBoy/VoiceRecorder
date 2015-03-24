package bigbigboy.example.com.voicerecorder.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import bigbigboy.example.com.voicerecorder.R;
import bigbigboy.example.com.voicerecorder.support.utils.PlayVoice;

/**
 * Created by BigBigBoy on 2015/3/21.
 */
public class MainLineAdapter extends BaseAdapter {
    private List list = null;
    private Context mContext;
    private static final String PATH = "/sdcard/KaiXin/Record/1.amr";// 录音存储路径

    public MainLineAdapter(Context mContext, List list) {
        this.mContext = mContext;
        this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        // final MessageBean videoInfo = (MessageBean) list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            Log.d("LayoutInflater", "LayoutInflater");
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.recyclerview_item, arg2, false);
            viewHolder.accountName = (TextView) view
                    .findViewById(R.id.acountname);
            viewHolder.content = (TextView) view.findViewById(R.id.content);
            viewHolder.createTime = (TextView) view
                    .findViewById(R.id.createtime);
            viewHolder.voiceControl = (ImageView) view.findViewById(R.id.voice_display_voice_play);
            viewHolder.playProgress = (ProgressBar) view.findViewById(R.id.voice_display_voice_progressbar);
            viewHolder.totalTime = (TextView) view.findViewById(R.id.voice_display_voice_time);
            final ProgressBar playProgressBar = viewHolder.playProgress;
            viewHolder.voiceControl.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(final View v) {
                    if (!v.isSelected()) {
                        // 修改播放图标
                        v.setSelected(true);
                        PlayVoice.getInstance().play(PATH,position);
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (PlayVoice.getInstance().getPlayingState() == 2) {
                                    playProgressBar.setMax(PlayVoice.getInstance().getDuration() / 1000);
                                    playProgressBar.setProgress(PlayVoice.getInstance().getCurrentPosition());
                                }
                            }
                        }, 1000, 1000);
                    } else {
                        v.setSelected(false);
                    }
                }
            });

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.accountName.setText("BigBigBoy");
        viewHolder.content.setText("人生这段旅程，我们无法预知将会遇见的风景，只要真心去欣赏，一切都是美不可言.");
        viewHolder.createTime.setText("2015年3月22日");
        return view;

    }

    final static class ViewHolder {
        TextView accountName;
        TextView content;
        TextView createTime;
        ImageView voiceControl;
        ProgressBar playProgress;
        TextView totalTime;
    }
}
