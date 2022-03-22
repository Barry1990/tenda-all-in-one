package com.tenda.aio;

import android.content.Context;

import com.arthenica.mobileffmpeg.ExecuteCallback;
import com.arthenica.mobileffmpeg.FFmpeg;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

public class FFmpegUtil {

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 视频截图
     * @param videoFile
     * @param atTime
     * @param call
     */
    public void ffScreenshot(String videoFile, Float atTime, Float imageW,Float imageH,PluginCall call){
        String cachePath = this.context.getCacheDir().getPath();
        String outPutFile = cachePath + System.currentTimeMillis() +"_ff_thumbnail.jpg";
        String cmd = String.format(" -ss %f -i %s -f image2 -s %dx%d -vframes 1 %s",atTime,videoFile,Math.round(imageW),Math.round(imageH),outPutFile);
        FFmpeg.executeAsync(cmd, new ExecuteCallback() {
           @Override
           public void apply(long executionId, int returnCode) {
               JSObject ret = new JSObject();
               ret.put("resultCode", returnCode);
               ret.put("outPutFile", outPutFile);
               call.resolve(ret);
           }
        });
    }

    /**
     * 视频转码
     * @param videoFile
     * @param videoBitrate
     * @param call
     */
    public void ffTransCode(String videoFile, String videoBitrate, PluginCall call){
        String cachePath = this.context.getCacheDir().getPath();
        String outPutFile = cachePath + System.currentTimeMillis() +"_ff_trans.mp4";
        String cmd = String.format(" -i %s -b:v %s -y %s",videoFile,videoBitrate,outPutFile);
        FFmpeg.executeAsync(cmd, new ExecuteCallback() {
            @Override
            public void apply(long executionId, int returnCode) {
                JSObject ret = new JSObject();
                ret.put("resultCode", returnCode);
                ret.put("outPutFile", outPutFile);
                call.resolve(ret);
            }
        });
    }
}
