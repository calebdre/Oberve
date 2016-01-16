package com.observe.Views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.VideoView;

import com.observe.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    static final int REQUEST_VIDEO_CAPTURE = 1;
    boolean toggled = false;
    @Bind(R.id.video_view) VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.CAPTURE_VIDEO_OUTPUT}, 50);
        }else{
            dispatchTakeVideoIntent();
        }
    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        dispatchTakeVideoIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.setMediaController(null);
            videoView.start();
            videoView.setOnCompletionListener(this);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        videoView.seekTo(0);
        videoView.start();
    }

    @OnClick(R.id.favorite)
    public void onFavoriteClick(View v){
        if(toggled){
            v.setBackground(getDrawable(R.drawable.favorite));
        }else{
            v.setBackground(getDrawable(R.drawable.favorite_active));
        }
        toggled = !toggled;
    }
}