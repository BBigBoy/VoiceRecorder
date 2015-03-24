package bigbigboy.example.com.voicerecorder.support.utils;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import java.util.Timer;

/**
 * Created by BigBigBoy on 2015/3/23.
 */
public class PlayVoice {

    private static PlayVoice player = new PlayVoice();
    private Timer timer;
    private MediaPlayer media;
    private int index;

    private PlayVoice() {
    }

    public static PlayVoice getInstance() {
        return player;
    }


    private int playingState = Config.PLAYING_STOP;

    public int getPlayingState() {
        return playingState;
    }

    private void syncProgressBarValue() {
        /*final ListView listView = MainActivity.xListView;

        if (listView != null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    View view = listView.getChildAt(index);
                    ProgressBar progressBar;
                    if (view != null) {
                        progressBar = (ProgressBar) (listView.getChildAt(index).findViewById(R.id.voice_display_voice_progressbar));
                        if (progressBar != null)
                            progressBar.setProgress(getCurrentPosition() / 1000);
                    }
                }
            }, 1000, 1000);
        }*/
    }

    // 获取播放的音乐文件总时间长度
    public int getDuration() {
        int durat = 0;
        if (media != null) {
            durat = media.getDuration();
        }
        return durat;
    }

    // 获取当前播放音乐时间点
    public int getCurrentPosition() {
        int currentPosition = 0;
        if (media != null) {
            currentPosition = media.getCurrentPosition();
        }
        return currentPosition;
    }

    // 将音乐播放跳转到某一时间点,以毫秒为单位
    public void seekTo(int msec) {
        if (media != null) {
            media.seekTo(msec);
        }
    }

    public void destroy() {
        if (media != null) {
            media.release();
            playingState = Config.PLAYING_STOP;
        }
    }

    public void stop() {
        if (playingState != Config.PLAYING_STOP) {
            media.reset();
            playingState = Config.PLAYING_STOP;
        }
    }

    public void pause() {
        if (playingState != Config.PLAYING_PAUSE) {
            media.pause();
            playingState = Config.PLAYING_PAUSE;
        }
    }

    // 正在暂停，即将开始继续播放
    public void replay() {
        if (playingState != Config.PLAYING_PLAY) {
            media.start();
            playingState = Config.PLAYING_PLAY;
        }
    }

    public void play(String path, int index) {
        this.index = index;
        // 如果有正在播放的歌曲，将它停止
        if (playingState == Config.PLAYING_PLAY) {
            media.reset();
        }
        media = MediaPlayer.create(GlobalContext.getInstance(),
                Uri.parse("file://" + path));
        try {
            media.start();
            syncProgressBarValue();
            media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                }
            });
            playingState = Config.PLAYING_PLAY;
        } catch (NullPointerException e) {
            Toast.makeText(GlobalContext.getInstance(), "亲，找不到音乐文件了，存储卡拔掉了吗？", Toast.LENGTH_LONG).show();
        }
    }

    private class Config {
        /**
         * 播放器状态
         */
        public static final int PLAYING_STOP = 0;
        public static final int PLAYING_PAUSE = 1;
        public static final int PLAYING_PLAY = 2;
    }


}
