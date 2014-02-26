package com.samiamharris.hellomoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by samharris on 2/25/14.
 */
public class HelloMoonFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;
    private Button mVideoButton;
    private AudioPlayer mPlayer = new AudioPlayer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(mPlayer.getPlayer() != null && mPlayer.getPlayer().isPlaying()) {
                    mPlayer.pause();
                    mPlayButton.setText(R.string.hellomoon_play);
                } else {
                    mPlayer.play(getActivity());
                    mPlayButton.setText(R.string.hellomoon_pause);

                }
            }
        });


        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayButton.setText(R.string.hellomoon_play);
            }
        });

        mVideoButton = (Button) v.findViewById(R.id.videoFragment_button);
        mVideoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), VideoActivity.class);
                startActivity(i);
            }
        });



        return v;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
