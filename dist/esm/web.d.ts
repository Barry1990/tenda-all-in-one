import { WebPlugin } from '@capacitor/core';
import type { AioUtilPlugin, ffScreenshotOptions, ffTransCodeOptions } from './definitions';
export declare class AioUtilWeb extends WebPlugin implements AioUtilPlugin {
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
