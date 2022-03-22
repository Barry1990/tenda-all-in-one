package com.tenda.aio;


import android.app.Activity;
import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.tenda.aio.activity.VideoCameraActivity;

@CapacitorPlugin(name = "AioUtil")
public class AioUtilPlugin extends Plugin {

    private FFmpegUtil ffmpegUtil = new FFmpegUtil();

    @PluginMethod
    public void ffScreenshot(PluginCall call) {
        String videoFile = call.getString("videoFile");
        Float atTime = call.getFloat("atTime");
        Float imageW = call.getFloat("imageW");
        Float imageH = call.getFloat("imageH");

        ffmpegUtil.setContext(this.getContext());
        ffmpegUtil.ffScreenshot(videoFile,atTime,imageW,imageH,call);
    }

    @PluginMethod
    public void ffTransCode(PluginCall call) {
        String videoFile = call.getString("videoFile");
        String videoBitrate = call.getString("videoBitrate");
        ffmpegUtil.setContext(this.getContext());
        ffmpegUtil.ffTransCode(videoFile,videoBitrate,call);
    }

    /**
     * 自定义录像
     * @param call
     */
    @PluginMethod
    public void takeVideo(PluginCall call){
        Activity mainActivity = this.getActivity();
        Intent intent = new Intent(mainActivity, VideoCameraActivity.class);
        mainActivity.startActivity(intent);
        JSObject ret = new JSObject();
        ret.put("resultCode", 1);
        ret.put("outPutFile", "");
        call.resolve(ret);
    }
}
