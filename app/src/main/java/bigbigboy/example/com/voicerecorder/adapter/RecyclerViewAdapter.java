package bigbigboy.example.com.voicerecorder.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import bigbigboy.example.com.voicerecorder.R;
import bigbigboy.example.com.voicerecorder.bean.MessageBean;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 1/17/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<MessageBean> list;

    public RecyclerViewAdapter(List<MessageBean> list) {
        this.list = list;
    }

    public static interface OnRecyclerViewListener {
        void onItemClick(int position);

        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.position = i;
        MessageBean messageBean = list.get(i);
        holder.accountName.setText(messageBean.getAccountNmae());
        holder.content.setText(messageBean.getContent());
        ((CardView) holder.rootView).setCardBackgroundColor(holder.rootView.getResources().getColor(messageBean.getBgcolor()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View rootView;
        TextView accountName;
        TextView content;
        TextView createTime;
        ImageView voiceControl;
        ProgressBar playProgress;
        TextView totalTime;
        public int position;

        public ViewHolder(View itemView) {
            super(itemView);
            accountName = (TextView) itemView.findViewById(R.id.acountname);
            content = (TextView) itemView.findViewById(R.id.content);
            rootView = itemView.findViewById(R.id.messagecardview);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener) {
                return onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }

}