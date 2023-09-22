package com.example.barkunisoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.service.controls.Control;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    SoundPool soundPool;
    int[] sounds;
    float volume;
    SeekBar volumeControl;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        int progressSaved = sharedPreferences.getInt("volumeSaved",50);
        volume = (float)(progressSaved/100);
        volumeControl = findViewById(R.id.volumeControl);
        volumeControl.setProgress(progressSaved,true);
        volumeControl.setOnSeekBarChangeListener(this);

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
        sounds = new int[11];
        sounds[0] = soundPool.load(this, R.raw.bevadai, 1);
        sounds[1] = soundPool.load(this, R.raw.halvia_shelcha, 1);
        sounds[2] = soundPool.load(this, R.raw.pitoomzevel, 1);
        sounds[3] = soundPool.load(this, R.raw.efes_silent, 1);
        sounds[4] = soundPool.load(this, R.raw.altaaneli, 1);
        sounds[5] = soundPool.load(this, R.raw.pgishamaosim, 1);
        sounds[6] = soundPool.load(this, R.raw.odpgisha, 1);
        sounds[7] = soundPool.load(this, R.raw.biltinitanlesipuk, 1);
        sounds[8] = soundPool.load(this, R.raw.cantforme, 1);
        sounds[9] = soundPool.load(this, R.raw.lenadevmeida, 1);
        sounds[10] =  soundPool.load(this, R.raw.gamlotov, 1);

    }


    @SuppressLint("NonConstantResourceId")
    public void playSound(View v){
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        switch (v.getId()) {
            case R.id.btn_sound_bevadai:
//                soundPool.autoPause();
                soundPool.play(
                        sounds[0],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_halvia_shelcha:
                soundPool.play(
                        sounds[1],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_pitoomzevel:
                soundPool.play(
                        sounds[2],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_efes:
                soundPool.play(
                        sounds[3],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_altaaneli:
                soundPool.play(
                        sounds[4],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_pgishamaosim:
                soundPool.play(
                        sounds[5],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_odpgisha:
                soundPool.play(
                        sounds[6],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_biltinitanlesipuk:
                soundPool.play(
                        sounds[7],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_cantforme:
                soundPool.play(
                        sounds[8],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_lenadevmeida:
                soundPool.play(
                        sounds[9],volume,volume, 1, 0, 1);
                break;
            case R.id.btn_sound_gamlotov:
                soundPool.play(
                        sounds[10],volume,volume, 1, 0, 1);
                break;



        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(b){
//            AudioManager systemService = (AudioManager) (getSystemService(Context.AUDIO_SERVICE));
//            double dryVolume = (double) i / (double) ;
            volume = (float)(i/100f);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("volumeSaved",i);
            editor.apply();

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}