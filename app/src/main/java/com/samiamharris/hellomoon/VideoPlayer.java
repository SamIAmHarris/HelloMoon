package com.samiamharris.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

/**
 * Created by samharris on 2/26/14.
 */
public class VideoPlayer {

    private MediaPlayer mPlayer;

    public MediaPlayer getPlayer() {
        return mPlayer;
    }

    public void stopVideo() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer=null;
        }
    }

    public void pauseVideo() {
        mPlayer.pause();
    }

    public void playVideo(Context c, SurfaceHolder holder){

        if(mPlayer == null) {

            mPlayer = MediaPlayer.create(c, R.raw.sample_mp4);
            mPlayer.setDisplay(holder);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopVideo();
                }
            });
            mPlayer.start();
        } else {
            mPlayer.start();
        }
    }
}
