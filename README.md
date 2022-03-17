# tenda-all-in-one

all in one

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
