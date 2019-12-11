package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnStop;
    private ImageButton btnPlay;
    private ImageButton btnPause;
    private TextView start;
    private TextView time;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private int pauseCurrent;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStop = findViewById(R.id.imgBtnStop);
        btnPlay = findViewById(R.id.imgBtnPlay);
        btnPause = findViewById(R.id.imgBtnPause);
        start = findViewById(R.id.textViewStart);
        time = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);
        tv2 = findViewById(R.id.textView2);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        String name2 = getIntent().getStringExtra("song");
        tv2.setText(" Welcome to Activity 2!" + name2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = (progress/1000)/60;
                int seconds = progress % (1000 * 60 * 60) % (1000 * 60) / 1000;
                time.setText(String.format("%d:%2d",minutes,seconds));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case (R.id.imgBtnPause):
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    pauseCurrent = mediaPlayer.getCurrentPosition();
                }
                break;
            case (R.id.imgBtnPlay):
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                    seekBar.setMax(mediaPlayer.getDuration());
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pauseCurrent);
                    mediaPlayer.start();
                }
                break;

            case (R.id.imgBtnStop):
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }
    }
}

