import { registerPlugin } from '@capacitor/core';
const AioUtil = registerPlugin('AioUtil', {
    web: () => import('./web').then(m => new m.AioUtilWeb()),
});
export * from './definitions';
export { AioUtil };
//# sourceMappingURL=index.js.map