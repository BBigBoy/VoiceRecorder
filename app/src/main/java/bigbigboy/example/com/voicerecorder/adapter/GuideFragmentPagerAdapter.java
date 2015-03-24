package bigbigboy.example.com.voicerecorder.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bigbigboy.example.com.voicerecorder.ui.fragment.GuideFragment;

/**
 * Created by BigBigBoy on 2015/3/18.
 */

public class GuideFragmentPagerAdapter extends FragmentPagerAdapter {
    private int[] guide_pics;
    private Fragment[] fragments;

    public GuideFragmentPagerAdapter(final int[] guidePics_ResId, FragmentManager fm) {
        super(fm);
        guide_pics = guidePics_ResId;
        fragments = new Fragment[guide_pics.length];
    }

    @Override
    public int getCount() {
        return guide_pics.length;
    }

    @Override
    public Fragment getItem(int position) {

        if (fragments[position] == null) {
            fragments[position] = GuideFragment.newInstance(guide_pics[position], (position + 1) == guide_pics.length);
        }
        return fragments[position];

    }
}


