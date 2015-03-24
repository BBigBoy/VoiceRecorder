package bigbigboy.example.com.voicerecorder.support.utils;

import android.app.Application;

/**
 * User: Jiang Qi
 * Date: 12-7-27
 */
public final class GlobalContext extends Application {

    //singleton
    private static GlobalContext globalContext = null;

    public static GlobalContext getInstance() {
        return globalContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;
    }

}

