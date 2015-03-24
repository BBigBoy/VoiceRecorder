package bigbigboy.example.com.voicerecorder.ui.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import bigbigboy.example.com.voicerecorder.R;
import bigbigboy.example.com.voicerecorder.ui.MainActivity;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link GuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuideFragment extends Fragment {
    private int resId;
    private boolean isBiggest;

    public static GuideFragment newInstance(final int resId, boolean isBiggest) {
        GuideFragment fragment = new GuideFragment();
        Bundle args = new Bundle();
        args.putInt("param1", resId);
        args.putBoolean("param2", isBiggest);
        fragment.setArguments(args);
        return fragment;
    }

    public GuideFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.resId = getArguments().getInt("param1");
            this.isBiggest = getArguments().getBoolean("param2");
            Log.d("onCreateonCreate", "onCreateonCreate" + resId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout view = new RelativeLayout(getActivity());
        view.setBackgroundResource(resId);
        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if (isBiggest) {
            Button btn = new Button(getActivity());
            btn.setText("开始记录");
            btn.setTextSize(18);
            btn.setTextColor(Color.WHITE);
            btn.setBackgroundResource(R.drawable.thumb_startbtn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
            RelativeLayout.LayoutParams lyParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lyParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            lyParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            lyParams.setMargins(0, 0, 0, 80);
            view.addView(btn, lyParams);
        }
        return view;
    }
}
