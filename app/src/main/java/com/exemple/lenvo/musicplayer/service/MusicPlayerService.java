package com.exemple.lenvo.musicplayer.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.exemple.lenvo.musicplayer.manager.MusicPlayerManager;
import com.exemple.lenvo.musicplayer.manager.PlayListManager;
import com.exemple.lenvo.musicplayer.manager.impl.MusicPlayerManagerImpl;
import com.exemple.lenvo.musicplayer.manager.impl.PlayListManagerImpl;
import com.exemple.lenvo.musicplayer.util.ServiceUtil;

public class MusicPlayerService extends Service {
    private static MusicPlayerManager manager;
    private static PlayListManager playListManager;

    public MusicPlayerService() {
    }

    /**
     * 提供一个静态方法获获取Manager
     * 为什么不支持将逻辑写到Service呢？
     * 是因为操作service要么通过bindService，那么startService麻烦
     * @param context
     * @return
     */
    public static MusicPlayerManager getMusicPlayerManager(Context context) {
        startService(context);
        if (MusicPlayerService.manager == null) {
            //初始化音乐播放管理器
            MusicPlayerService.manager = MusicPlayerManagerImpl.getInstance(context);
        }
        return manager;
    }

    private static void startService(Context context) {
        if (!ServiceUtil.isServiceRunning(context)) {
            //如果当前Service没有引用就要启动它
            Intent downloadSvr = new Intent(context, MusicPlayerService.class);
            context.startService(downloadSvr);
        }
    }

    /**
     * 获取一个PlayListManager对象
     * @param context
     * @return
     */
    public static PlayListManager getPlayListManager(Context context) {
        startService(context);

        if (MusicPlayerService.playListManager == null) {
            //初始化列表管理器
            MusicPlayerService.playListManager = PlayListManagerImpl.getInstance(context);
        }
        return playListManager;
    }

    //不是通过远程实现，onBind方法不用
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
