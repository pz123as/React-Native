package com.testandroid;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by guojicheng on 2016/5/18.
 */
public class NetModule extends ReactContextBaseJavaModule{

    private static final String MODULE_NAME = "Net";

    public NetModule(ReactApplicationContext context){
        super(context);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void getResult(String url, final Callback callback){
        Log.e("TAG", "正在请求数据");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String result = "这是结果";
                    Thread.sleep(1000);
                    callback.invoke(true, result);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
