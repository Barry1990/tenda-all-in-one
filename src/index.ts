import { registerPlugin } from '@capacitor/core';

import type { AioUtilPlugin } from './definitions';

const AioUtil = registerPlugin<AioUtilPlugin>('AioUtil', {
  web: () => import('./web').then(m => new m.AioUtilWeb()),
});

export * from './definitions';
export { AioUtil };
