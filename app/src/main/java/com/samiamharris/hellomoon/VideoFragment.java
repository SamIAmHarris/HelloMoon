package com.samiamharris.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by samharris on 2/26/14.
 */
public class VideoFragment extends Fragment {

    private Button videoPlayButton;
    private Button videoStopButton;
    private SurfaceView surfaceView;
    public SurfaceHolder surfaceHolder;
    private VideoPlayer mPlayer = new VideoPlayer();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_video, container, false);

        surfaceView = (SurfaceView) v.findViewById(R.id.videoSurfaceView);
        surfaceHolder = surfaceView.getHolder();

        videoPlayButton = (Button) v.findViewById(R.id.hellomoon_videoPlayButton);
        videoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPlayer.getPlayer() != null && mPlayer.getPlayer().isPlaying()) {
                    mPlayer.pauseVideo();
                    videoPlayButton.setText(R.string.hellomoon_play);
                } else {
                mPlayer.playVideo(getActivity(), surfaceHolder);
                videoPlayButton.setText(R.string.hellomoon_pause);
                }
            }
        });

        videoStopButton = (Button) v.findViewById(R.id.hellomoon_videoStopButton);
        videoStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stopVideo();

            }
        });

        return v;
    }
}
