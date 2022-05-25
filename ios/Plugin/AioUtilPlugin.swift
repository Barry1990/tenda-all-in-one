import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(AioUtilPlugin)
public class AioUtilPlugin: CAPPlugin {
    private let ffmpegUtil = FFmpegUtil()

    @objc func ffScreenshot(_ call: CAPPluginCall) {
        let videoFile = call.getString("videoFile") ?? "";
        let atTime = call.getFloat("atTime") ?? 0.0;
        let imageW = call.getFloat("imageW") ?? 0.0;
        let imageH = call.getFloat("imageH") ?? 0.0;
        ffmpegUtil.ffScreenshot(videoFile: videoFile, atTime: atTime ,imageW: imageW , imageH: imageH, call: call);
    }
    
    @objc func ffTransCode(_ call: CAPPluginCall) {
        let videoFile = call.getString("videoFile") ?? "";
        let videoBitrate = call.getString("videoBitrate") ?? "6000k";
        ffmpegUtil.ffTransCode(videoFile: videoFile, videoBitrate: videoBitrate , call: call);
    }

     @objc func ffCmd(_ call: CAPPluginCall) {
        let cmd = call.getString("cmd");
        ffmpegUtil.ffCmd(cmd: cmd , call: call);
    }
}
