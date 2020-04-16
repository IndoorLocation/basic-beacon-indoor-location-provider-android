package io.indoorlocation.basicbeacon.demoapp;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.Locale;

import io.indoorlocation.basicbeaconlocationprovider.BasicBeaconIndoorLocationProvider;
import io.indoorlocation.gps.GPSIndoorLocationProvider;
import io.mapwize.mapwizesdk.api.MapwizeObject;
import io.mapwize.mapwizesdk.map.MapOptions;
import io.mapwize.mapwizesdk.map.MapwizeMap;
import io.mapwize.mapwizesdk.map.MapwizeView;
import io.mapwize.mapwizeui.MapwizeFragment;
import io.mapwize.mapwizeui.MapwizeFragmentUISettings;

public class MapActivity extends AppCompatActivity implements MapwizeFragment.OnFragmentInteractionListener {

    private MapwizeFragment mapwizeFragment;
    private BasicBeaconIndoorLocationProvider basicBeaconIndoorLocationProvider;
    private GPSIndoorLocationProvider gpsIndoorLocationProvider;
    private static final int MY_PERMISSION_ACCESS_FINE_LOCATION = 0;

    MapwizeView mapwizeView;
    MapwizeMap mapwizeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FrameLayout container = findViewById(R.id.container);

        MapOptions opts = new MapOptions.Builder()
                .language(Locale.getDefault().getLanguage()).build();
        mapwizeFragment = MapwizeFragment.newInstance(opts);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(container.getId(), mapwizeFragment);
        ft.commit();

    }

    @Override
    public void onStart() {
        super.onStart();
        mapwizeFragment.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapwizeFragment.onResume();
    }

    @Override
    public void onPause() {
        mapwizeFragment.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mapwizeFragment.onStop();
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        mapwizeFragment.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapwizeFragment.onLowMemory();
    }

    @Override
    public void onDestroy() {
        mapwizeFragment.onDestroy();
        super.onDestroy();
    }

    private void startLocationService() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_ACCESS_FINE_LOCATION);
        }
        else {
            setupLocationProvider();
        }
    }

    private void setupLocationProvider() {
        gpsIndoorLocationProvider = new GPSIndoorLocationProvider(this);
        basicBeaconIndoorLocationProvider = new BasicBeaconIndoorLocationProvider(this, "1f04d780dc30b774c0c10f53e3c7d4ea", gpsIndoorLocationProvider);
        basicBeaconIndoorLocationProvider.start();
        mapwizeMap.setIndoorLocationProvider(basicBeaconIndoorLocationProvider);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setupLocationProvider();
                }
            }
        }
    }

    @Override
    public void onMenuButtonClick() {
        Log.i("MapActivity", "onMenuButtonClick");
    }

    @Override
    public void onInformationButtonClick(MapwizeObject mapwizeObject) {
        Log.i("MapActivity", "onInformationButtonClick");
    }

    @Override
    public void onFragmentReady(MapwizeMap mapwizeMap) {
        this.mapwizeMap = mapwizeMap;
        startLocationService();
    }

    @Override
    public void onFollowUserButtonClickWithoutLocation() {
        Log.i("MapActivity", "onFollowUserButtonClickWithoutLocation");
    }
}
