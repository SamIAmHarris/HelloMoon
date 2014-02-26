package com.samiamharris.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by samharris on 2/25/14.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    public MediaPlayer getPlayer() {
        return mPlayer;
    }

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer=null;
        }
    }

    public void pause() {
        mPlayer.pause();
    }

    public void play(Context c){

        if(mPlayer == null) {

            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
            mPlayer.start();
        } else {
            mPlayer.start();
        }
    }

}

