import { WebPlugin } from '@capacitor/core';
export class AioUtilWeb extends WebPlugin {
    ffCmd(options) {
        console.log('ffCmd', options);
        throw new Error('Method not implemented.');
    }
    takeVideo() {
        throw new Error('Method not implemented.');
    }
    async ffTransCode(options) {
        console.log('ffTransCode', options);
        throw new Error('Method not implemented.');
    }
    async ffScreenshot(options) {
        console.log('ffScreenshot', options);
        throw new Error('Method not implemented.');
    }
}
//# sourceMappingURL=web.js.map