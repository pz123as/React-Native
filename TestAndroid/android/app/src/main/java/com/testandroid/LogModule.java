package com.testandroid;

import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Map;

public class LogModule extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "Log";
    private static final String TAG_KEY = "TAG";
    private static final String TAG_VALUE = "LogModule";

    public LogModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void d(String tag, String msg) {
        Log.d(tag, msg);
        WritableMap params = Arguments.createMap();
        params.putString("TAG", tag);
        params.putString("MSG", msg);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("logInConsole", params);
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = MapBuilder.newHashMap();
        constants.put(TAG_KEY, TAG_VALUE);
        return constants;
    }
}
