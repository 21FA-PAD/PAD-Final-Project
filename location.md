# Location Services

- Specify different location sensitivities in the manifest
  - Fine location uses GPS, cell and Wi-Fi
  - Coarse location uses cell and Wi-Fi

## Permissions
  - Beginning with API 23, users grant permissions to the app when it is running, not when it is installed.
  - To request “dangerous” permissions
    -  In `onResume`, check if permission has been granted.  If it hasn't been, request permission
    - Handle the permission request response by overriding the `onRequestPermissionsResult` method


### Requesting Location  
- To access location in a power friendly way use FusedLocation
- After retrieving permission, create a new `FusedLocationProviderClient` object,
which is the main entry point for interacting with the fused location provider.
- Create a [LocationCallback](https://developers.google.com/android/reference/com/google/android/gms/location/LocationCallback) object that is used for receiving notifications from the FusedLocationProvider when the device location has changed or can't be determined.
- Create a [LocationRequest](https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest)  data object that contains quality of service parameters for requests to the Fused LocationProvider.


## `LocationRequest` object
- Set the interval between location requests
- Set the Location Services Priorities
  - `PRIOIRTY_HIGH_ACCURACY` - very precise
  - `PRIORITY_BALANCED_POWER_ACCURACY` - block level,  battery friendly
  - `PRIORITY_LOW_POWER` - city level, very battery friendly
  - `PRIORITY_NO_POWER` - best possible accuracy at no power cost, may use location requested by other apps
