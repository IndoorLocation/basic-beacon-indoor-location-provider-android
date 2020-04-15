package io.indoorlocation.basicbeacon.demoapp;

import android.app.Application;

import com.mapbox.mapboxsdk.Mapbox;

import io.mapwize.mapwizesdk.core.MapwizeConfiguration;

public class BasicBeaconIndoorLocationProviderDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mapbox.getInstance(this, "pk.mapwize");
        // Mapwize globale initialization
        MapwizeConfiguration config = new MapwizeConfiguration.Builder(this, "YOUR_API_KEY").build();
        MapwizeConfiguration.start(config);
    }

}
