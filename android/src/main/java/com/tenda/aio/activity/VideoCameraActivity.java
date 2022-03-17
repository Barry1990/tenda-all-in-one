package com.tenda.aio.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.tenda.aio.cameralibrary.JCameraView;
import com.tenda.aio.cameralibrary.listener.ClickListener;
import com.tenda.aio.cameralibrary.listener.ErrorListener;
import com.tenda.aio.cameralibrary.listener.JCameraListener;
import com.tenda.aio.cameralibrary.util.FileUtil;
import com.tenda.aio.R;

/**
 * @author LLhon
 * @Project Android-Video-Editor
 * @Package com.marvhong.videoeditor
 * @Date 2018/8/22 10:54
 * @description 视频拍摄界面
 */
public class VideoCameraActivity extends Activity {

//    @BindView(R.id.jcameraview)
    JCameraView mJCameraView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayoutId());
        initView();
    }

    protected int getLayoutId() {
        return R.layout.activity_video_camera;
    }

    protected void init() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected void initView() {
        mJCameraView = this.findViewById(R.id.jcameraview);
        //设置视频保存路径
        mJCameraView.setSaveVideoPath("/data/user/0/com.tepss.dojowm/cache/videoeditor/small_video");
//        mJCameraView.setMinDuration(3000); //设置最短录制时长
//        mJCameraView.setDuration(10000); //设置最长录制时长
        mJCameraView.setFeatures(JCameraView.BUTTON_STATE_ONLY_RECORDER);
        mJCameraView.setTip("长按拍摄, 3~10秒");
//        mJCameraView.setRecordShortTip("录制时间3~10秒");
        mJCameraView.setMediaQuality(6000000);
        mJCameraView.setErrorLisenter(new ErrorListener() {
            @Override
            public void onError() {
                //错误监听
                Log.d("CJT", "camera error");
                Intent intent = new Intent();
                setResult(103, intent);
                finish();
            }

            @Override
            public void AudioPermissionError() {
                Toast.makeText(VideoCameraActivity.this, "给点录音权限可以?", Toast.LENGTH_SHORT).show();
            }
        });
        //JCameraView监听
        mJCameraView.setJCameraLisenter(new JCameraListener() {
            @Override
            public void captureSuccess(Bitmap bitmap) {
                //获取图片bitmap
//                Log.i("JCameraView", "bitmap = " + bitmap.getWidth());
                String path = FileUtil.saveBitmap("small_video", bitmap);
            }

            @Override
            public void recordSuccess(String url, Bitmap firstFrame) {
                //获取视频路径
                String path = FileUtil.saveBitmap("small_video", firstFrame);
                //url:/storage/emulated/0/haodiaoyu/small_video/video_1508930416375.mp4, Bitmap:/storage/emulated/0/haodiaoyu/small_video/picture_1508930429832.jpg
                Log.d("CJT", "url:" + url + ", firstFrame:" + path);

//                TrimVideoActivity.startActivity(VideoCameraActivity.this, url);
                finish();
            }
        });
        mJCameraView.setLeftClickListener(new ClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
        mJCameraView.setRightClickListener(new ClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(VideoCameraActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });
//        mJCameraView.setRecordStateListener(new RecordStateListener() {
//            @Override
//            public void recordStart() {
//
//            }
//
//            @Override
//            public void recordEnd(long time) {
//                Log.e("录制状态回调", "录制时长：" + time);
//            }
//
//            @Override
//            public void recordCancel() {
//
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //全屏显示
        if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mJCameraView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mJCameraView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
