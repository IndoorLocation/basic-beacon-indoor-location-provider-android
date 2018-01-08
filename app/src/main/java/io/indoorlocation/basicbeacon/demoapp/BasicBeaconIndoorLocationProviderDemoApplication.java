package io.indoorlocation.basicbeacon.demoapp;

import android.app.Application;

import io.mapwize.mapwizeformapbox.AccountManager;

public class BasicBeaconIndoorLocationProviderDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AccountManager.start(this, "1f04d780dc30b774c0c10f53e3c7d4ea");// PASTE YOU MAPWIZE API KEY HERE !!! This is a demo key, giving you access to the demo building. It is not allowed to use it for production. The key might change at any time without notice. Get your key by signin up at mapwize.io
    }

}
