'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const AioUtil = core.registerPlugin('AioUtil', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.AioUtilWeb()),
});

class AioUtilWeb extends core.WebPlugin {
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

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    AioUtilWeb: AioUtilWeb
});

exports.AioUtil = AioUtil;
//# sourceMappingURL=plugin.cjs.js.map