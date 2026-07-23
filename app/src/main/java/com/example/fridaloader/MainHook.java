package com.example.fridaloader;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import android.util.Log;

public class MainHook implements IXposedHookLoadPackage {
    private static final String TAG = "FridaLoader";
    private static final String TARGET_PACKAGE = "com.taobao.taobao";
    private static final String GADGET_PATH = "/data/local/tmp/libfrida-gadget.so";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals(TARGET_PACKAGE)) return;

        Log.i(TAG, "Loading Frida Gadget for " + TARGET_PACKAGE);
        try {
            System.load(GADGET_PATH);
            Log.i(TAG, "Frida Gadget loaded successfully");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load Gadget: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Unexpected error: " + e.getMessage());
        }
    }
}
