package com.example.niall.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

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
        // For this method to work, the button within the activity_main.xml must have a tag
        // attribute set to the file name of the sound clip it will play when pressed.
        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);
        int buttonId;
        int fileId;
        String fileName;
        for (int i = 0; i < grid.getChildCount(); i++) {
            buttonId = grid.getChildAt(i).getId();
            fileName = grid.getChildAt(i).getTag().toString();
            fileId = getResources().getIdentifier(fileName, "raw", getPackageName());

            buttonIdToSoundClipId.put(buttonId, fileId);
        }
    }

    public void playPhrase(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, buttonIdToSoundClipId.get(view.getId()));
        mediaPlayer.start();
    }
}
