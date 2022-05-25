export interface ffScreenshotOptions {
    /**
     * 视频路径
     */
    videoFile: string;
    /**
     * 截图时间
     */
    atTime: number;
    /**
     * 图片宽度
     */
    imageW: number;
    /**
     * 图片高度
     */
    imageH: number;
}
export interface ffTransCodeOptions {
    /**
     * 视频路径
     */
    videoFile: string;
    /**
     * 比特率（例如：6000k）
     */
    videoBitrate: string;
}
export interface ffCmdOptions {
    /**
     * ffmpeg命令（-i input.png  -vf scale=iw:ih -codec libwebp -lossless 0 -quality 75 out.jpg）
     */
    cmd: string;
}
export interface AioUtilPlugin {
    /**
     * 视频截图（原图）
     * @param options
     */
    ffScreenshot(options: ffScreenshotOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    /**
     * 视频转码
     * @param options
     */
    ffTransCode(options: ffTransCodeOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    /**
     *
     * @param options
     */
    ffCmd(options: ffCmdOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    /**
     * 录视频
     */
    takeVideo(): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
}
