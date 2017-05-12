package com.example.ianblanco.experimentgame;

import android.content.Context;
import android.media.MediaPlayer;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.music.MusicManager;

import java.io.IOException;

/**
 * Created by IanBlanco on 10/11/2016.
 */


public class BounceSound extends Music {
    private Music music;

    public BounceSound(MusicManager pMusicManager, Context context, MediaPlayer pMediaPlayer, String musicFile) {
        super(pMusicManager, pMediaPlayer);

       try {
           music = MusicFactory.createMusicFromAsset(pMusicManager, context, musicFile);
       } catch (IOException e) {
           e.printStackTrace();
       }
       this.setLooping(false);
    }



}
