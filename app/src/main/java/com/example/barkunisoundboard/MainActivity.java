package com.example.barkunisoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    SoundPool soundPool;
    int sound_bevadai,
            sound_efes,
            sound_yellingEviatar,
            sound_halvia_shelcha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        AudioAttributes
                audioAttributes
                = new AudioAttributes
                .Builder()
                .setUsage(
                        AudioAttributes
                                .USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(
                        AudioAttributes
                                .CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool
                .Builder()
                .setMaxStreams(3)
                .setAudioAttributes(
                        audioAttributes)
                .build();

        // This load function takes
        // three parameter context,
        // file_name and priority.
        sound_bevadai = soundPool.load(this, R.raw.bevadai, 1);
        sound_halvia_shelcha = soundPool.load(this, R.raw.halvia_shelcha, 1);
    }


    public void playSound(View v){
        switch (v.getId()) {
            case R.id.btn_sound_bevadai:

                // This play function
                // takes five parameter
                // leftVolume, rightVolume,
                // priority, loop and rate.
//                soundPool.autoPause();
                soundPool.play(
                        sound_bevadai, 1, 1, 1, 0, 1);
                break;
            case R.id.btn_sound_halvia_shelcha:
                soundPool.play(
                        sound_halvia_shelcha, 1, 1, 1, 0, 1);
                break;

        }
    }


}