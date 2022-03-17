import { WebPlugin } from '@capacitor/core';

import type { AioUtilPlugin,ffScreenshotOptions, ffTransCodeOptions } from './definitions';

export class AioUtilWeb extends WebPlugin implements AioUtilPlugin {
  
  takeVideo(): Promise<{ resultCode: number; outPutFile: string; }> {
    throw new Error('Method not implemented.');
  }

  async ffTransCode(options: ffTransCodeOptions): Promise<{ resultCode: number ,outPutFile: string; }> {
    console.log('ffTransCode',options);
    throw new Error('Method not implemented.');
  }

  async ffScreenshot(options: ffScreenshotOptions): Promise<{ resultCode: number ,outPutFile: string; }> {
    console.log('ffScreenshot',options);
    throw new Error('Method not implemented.');
  }
}
