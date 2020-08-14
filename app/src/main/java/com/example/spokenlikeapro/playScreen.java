package com.example.spokenlikeapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;


public class playScreen extends AppCompatActivity {

    private TextureView videoPreview;
    private TextureView.SurfaceTextureListener videoListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
            setupCamera(i,i1);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }

    };
    private CameraDevice cameraDevice;
    private CameraDevice.StateCallback cameraDeviceStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            cameraDevice = cameraDevice;
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            cameraDevice.close();
            cameraDevice = null;
        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            cameraDevice = null;
        }
    };
    private HandlerThread mBackgroundHandlerThread;

    private String mcameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        hideSystemUI.fullscreen(this);
        videoPreview = (TextureView) findViewById(R.id.texturePreview);
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (videoPreview.isAvailable()){
            setupCamera(videoPreview.getWidth(),videoPreview.getHeight());
        }else {
            videoPreview.setSurfaceTextureListener(videoListener);
        }
    }

    @Override
    protected void onPause() {
        closeCamera();
        super.onPause();
    }

    private void setupCamera(int width, int height){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            for(String cameraId : cameraManager.getCameraIdList()){
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId);
                if (cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) ==
                        cameraCharacteristics.LENS_FACING_FRONT){
                    continue;
                }
                mcameraId = cameraId;
                return;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void closeCamera(){
        if(cameraDevice != null){
            cameraDevice.close();
            cameraDevice = null;
        }
    }

    public void post(View view) {
        Intent changePassword = new Intent(playScreen.this,postRecord.class);
        startActivity(changePassword);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(playScreen.this,topic.class);
        startActivity(tohome);
    }
}