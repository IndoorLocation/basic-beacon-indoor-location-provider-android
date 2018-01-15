# Basic beacon IndoorLocation on Android

This provider allows you to simply deploy basic indoor positioning using iBeacons. All you need to do is dispose iBeacons around your buildings, register their locations on Mapwize and add this projet in your app. 

The location returned by this provider is simply the position of the closest iBeacon. There is no trilateration or sensor fusion.

If you are looking for a more precise and robust solution for indoor positioning using iBeacons, we advise you to take a look at professional solutions having IndoorLocation providers like:

- [Polestar](https://github.com/IndoorLocation/polestar-indoor-location-provider-android)
- Beco - coming soon
- Ubudu - coming soon

## Use

Instanciate the provider using your Mapwize credentials. The provider uses the GPS to know what iBeacons it can expect to find around you, so you need to pass a gps provider too.

```
gpsIndoorLocationProvider = new GPSIndoorLocationProvider(this);
basicBeaconIndoorLocationProvider = new BasicBeaconIndoorLocationProvider(this, "Mapwize Api Key", gpsIndoorLocationProvider);
```

Set the provider in your Mapwize SDK:

```
mapwizePlugin.setLocationProvider(basicBeaconIndoorLocationProvider);     
```

## Position the iBeacons on the Mapwize map

The position of the iBeacons need to be registered on Mapwize Studio. In that way, when beacons are detected, the provider knows what location to use.

To do so:

- Log in on [studio.mapwize.io](https://studio.mapwize.io). If you don't have an account yet, sign up at [mapwize.io](https://www.mapwize.io).
- Select your ve nue
- Go to the 'Beacons' section
- Add a beacon for each iBeacon. Use the type "iBeacon" and set the UUID, major and minor. TxPower is not used in this provider.

## Demo app

A simple demo application to test the provider is available in the /app directory.

You will need to set your credentials in BasicBeaconIndoorLocationProviderDemoApplication.java and MapActivity.java.

Sample keys are given for Mapwize and Mapbox. Please note that those keys can only be used for testing purposes, with very limited traffic, and cannot be used in production. Get your own keys from [mapwize.io](https://www.mapwize.io) and [mapbox.com](https://www.mapbox.com). Free accounts are available.

## Contribute

Contributions are welcome. We will be happy to review your PR.

## Support

For any support with this provider, please do not hesitate to contact [support@mapwize.io](mailto:support@mapwize.io)

## License

MIT