package com.chinapex.apexdatacollectsample;

import android.app.Application;

import com.chinapex.android.datacollect.ApexAnalytics;
import com.chinapex.apexdatacollectsample.utils.AppLog;

/**
 * @author SteelCabbage
 * @date 2018/11/05
 */

public class SampleApp extends Application {

    private static final String TAG = SampleApp.class.getSimpleName();

    private static SampleApp sSampleApp;

    @Override
    public void onCreate() {
        super.onCreate();
        AppLog.i(TAG, "SampleApp start!");
        sSampleApp = this;

        long time = System.currentTimeMillis();

        // settings
        ApexAnalytics.getInstance().setLogLevel(AppLog.VERBOSE);
        ApexAnalytics.getInstance().setDelayReportInterval(1000 * 60 * 2);
        ApexAnalytics.getInstance().setCheckInstantErrInterval(1000 * 60);
        ApexAnalytics.getInstance().setReportMaxNum(5);

        // 初始化埋点sdk
        ApexAnalytics.getInstance().init(sSampleApp);

        AppLog.w(TAG, "================init ApexAnalytics cost time================:" + (System
                .currentTimeMillis() - time));
    }

    public static SampleApp getInstance() {
        return sSampleApp;
    }

}