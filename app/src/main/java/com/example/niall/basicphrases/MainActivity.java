package com.example.niall.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private HashMap<Integer, Integer> buttonIdToSoundClipId = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtonMapping();
    }

    private void setupButtonMapping() {
        buttonIdToSoundClipId.put(R.id.button0, R.raw.hello);
        buttonIdToSoundClipId.put(R.id.button1, R.raw.goodevening);
        buttonIdToSoundClipId.put(R.id.button2, R.raw.please);
        buttonIdToSoundClipId.put(R.id.button3, R.raw.welcome);
        buttonIdToSoundClipId.put(R.id.button4, R.raw.mynameis);
        buttonIdToSoundClipId.put(R.id.button5, R.raw.ilivein);
        buttonIdToSoundClipId.put(R.id.button6, R.raw.doyouspeakenglish);
        buttonIdToSoundClipId.put(R.id.button7, R.raw.howareyou);
    }

    public void playPhrase(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, buttonIdToSoundClipId.get(view.getId()));
        mediaPlayer.start();
    }
}
