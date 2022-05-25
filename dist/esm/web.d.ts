import { WebPlugin } from '@capacitor/core';
import type { AioUtilPlugin, ffCmdOptions, ffScreenshotOptions, ffTransCodeOptions } from './definitions';
export declare class AioUtilWeb extends WebPlugin implements AioUtilPlugin {
    ffCmd(options: ffCmdOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    takeVideo(): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    ffTransCode(options: ffTransCodeOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
    ffScreenshot(options: ffScreenshotOptions): Promise<{
        resultCode: number;
        outPutFile: string;
    }>;
}
