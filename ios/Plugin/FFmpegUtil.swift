//
//  FFmpegUtil.swift
//  Plugin
//
//  Created by Tenda-xue on 2022/3/14.
//  Copyright © 2022 Max Lynch. All rights reserved.
//

import Foundation
import mobileffmpeg
import Capacitor


@objc public class FFmpegUtil: NSObject, ExecuteDelegate {
    
    var _call: CAPPluginCall?;
    var _outPutFile: String = "";
    
    /**
     视频截图
     */
    @objc public func ffScreenshot(videoFile: String, atTime: Float , imageW: Float , imageH: Float, call: CAPPluginCall) {
        _call = call;
        let cachePath = NSHomeDirectory() + "/Library/Caches/"
        let  now =  NSDate ();
        let outPutFile: String =  String(format: "%@%d_%f_ff_thumbnail.jpg", cachePath,Int(now.timeIntervalSince1970),atTime);
        let cmd = String(format: " -ss %f -i %@ -f image2 -s %dx%d  -vframes 1 %@", atTime, videoFile, Int(imageW), Int(imageH), outPutFile);
        MobileFFmpeg.executeAsync(cmd, withCallback: self);
        _outPutFile = outPutFile;
    }
    
    /**
     视频转码
     */
    @objc public func ffTransCode(videoFile: String, videoBitrate: String , call: CAPPluginCall ){
        _call = call;
        let cachePath = NSHomeDirectory() + "/Library/Caches/"
        let  now =  NSDate ();
        let outPutFile: String =  String(format: "%@%d_ff_trans.mp4", cachePath,Int(now.timeIntervalSince1970));
        let cmd = String(format: " -i %@ -b:v %@ -y %@", videoFile,videoBitrate, outPutFile);
        MobileFFmpeg.executeAsync(cmd, withCallback: self);
        _outPutFile = outPutFile;
    }
 
    /**
     ffmpeg回调
     */
    public func executeCallback(_ executionId: Int, _ returnCode: Int32) {
        _call!.resolve([
            "resultCode": returnCode,
            "outPutFile": _outPutFile
        ])
    }
    

}
