# tenda-all-in-one

这是个Ionic Capacitor自定义插件，近期在使用ionic开发app，官方的插件已经无法满足开发需求，所以打算做个全家桶插件。

## 自豪的集成了如下优秀的框架

* tanersener/mobile-ffmpeg
* CJT2325/CameraView

## Install

```bash
npm install tenda-all-in-one
npx cap sync
```

## API

<docgen-index>

* [`ffScreenshot(...)`](#ffscreenshot)
* [`ffTransCode(...)`](#fftranscode)
* [`takeVideo()`](#takevideo)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### ffScreenshot(...)

```typescript
ffScreenshot(options: ffScreenshotOptions) => Promise<{ resultCode: number; outPutFile: string; }>
```

视频截图（原图）

| Param         | Type                                                                |
| ------------- | ------------------------------------------------------------------- |
| **`options`** | <code><a href="#ffscreenshotoptions">ffScreenshotOptions</a></code> |

**Returns:** <code>Promise&lt;{ resultCode: number; outPutFile: string; }&gt;</code>

--------------------


### ffTransCode(...)

```typescript
ffTransCode(options: ffTransCodeOptions) => Promise<{ resultCode: number; outPutFile: string; }>
```

视频转码

| Param         | Type                                                              |
| ------------- | ----------------------------------------------------------------- |
| **`options`** | <code><a href="#fftranscodeoptions">ffTransCodeOptions</a></code> |

**Returns:** <code>Promise&lt;{ resultCode: number; outPutFile: string; }&gt;</code>

--------------------


### takeVideo()

```typescript
takeVideo() => Promise<{ resultCode: number; outPutFile: string; }>
```

录视频

**Returns:** <code>Promise&lt;{ resultCode: number; outPutFile: string; }&gt;</code>

--------------------


### Interfaces


#### ffScreenshotOptions

| Prop            | Type                | Description |
| --------------- | ------------------- | ----------- |
| **`videoFile`** | <code>string</code> | 视频路径        |
| **`atTime`**    | <code>number</code> | 截图时间        |


#### ffTransCodeOptions

| Prop               | Type                | Description   |
| ------------------ | ------------------- | ------------- |
| **`videoFile`**    | <code>string</code> | 视频路径          |
| **`videoBitrate`** | <code>string</code> | 比特率（例如：6000k） |

</docgen-api>
