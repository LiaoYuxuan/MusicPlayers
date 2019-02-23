package com.exemple.lenvo.musicplayer.manager;

import com.exemple.lenvo.musicplayer.domain.Song;
import com.exemple.lenvo.musicplayer.listener.PlayListListener;

import java.util.List;

/*
 *   项目名：  Musicplayer
 *   包名：    com.exemple.lenvo.musicplayer.manager
 *   文件名：  PlayListManager
 *   创建者：  LYX
 *   创建时间：2019/2/23 16:22
 *   描述：    TODO
 */
public interface PlayListManager {
    List<Song> getPlayList();

    void setPlayList(List<Song> datum);

    void play(Song song);

    void pause();

    void resume();

    void delete(Song song);

    Song getPlayData();

    Song next();

    Song previous();

    int getLoopModel();

    int changeLoopModel();

    void addPlayListListener(PlayListListener listener);

    void removePlayListListener(PlayListListener listener);

    void destroy();

    /**
     * 下一首播放
     * @param song
     */
    void nextPlay(Song song);
}
