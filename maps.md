# Maps

## API Key
- To use the Google Maps Android API, you must register your project on the Google Developers console and get an API key.
- To get an API key, follow [these instructions](https://developers.google.com/maps/documentation/android-api/start)  

## Locations
- Lewis Location
  - Latitude: 41.6047250
  - Longitude: -88.0813330
- Chicago
  - Latitude: 41.881832
  - Longitude: -87.623177

## Positioning the camera
- Build a `CameraPosition` using a `CameraPosition.Builder`
- Camera settings
  - bearing is the direction is pointing in, in degrees clockwise from north.
    - 0 is north 180 is south
  - tilt is the angle of the camera
      -  90 is looking straight down
      -  65 is somewhat of an angle, which gives a 3D perspective
  - zoom - larger number is closer to earth
- **Experiment with different values**

## Map Types
- Normal - typical road map
- Hybrid -satellite photograph data with road maps added
- Satellite - satellite photograph data.
- Terrain - topographic data
- None

## Markers
- A marker is an icon placed at a particular point on the map's surface
- To add a marker to a map use the GoogleMap `addMarker` method
- Set up markers using `MarkerOptions`
- For more information on using maps and markers, consult [Google Maps API](https://developers.google.com/maps/documentation/android-api/marker)

## Attribution
If you develop a Google Maps or Google Places API Web Service application, you must make available a Terms of Use and a Privacy Policy with your application which meets the guidelines outlined in Section 9.3 of the [Google Maps APIs Terms of Service](https://developers.google.com/maps/terms).
