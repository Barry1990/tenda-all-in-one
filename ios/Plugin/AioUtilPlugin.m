#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(AioUtilPlugin, "AioUtil",
           CAP_PLUGIN_METHOD(ffScreenshot, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(ffTransCode, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(ffCmd, CAPPluginReturnPromise);

)

