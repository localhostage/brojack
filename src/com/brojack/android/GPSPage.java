package com.brojack.android;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GPSPage extends Activity {
	
	
	TextView txtLat;
	TextView txtLng;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps);
        
        txtLat = (TextView) findViewById(R.id.txtLat);
        txtLng = (TextView) findViewById(R.id.txtLng);
  
    }
    
    public void doGps(View view)
    {
    	LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	Criteria criteria = new Criteria();
    	criteria.setAccuracy(Criteria.ACCURACY_FINE);
    	criteria.setAltitudeRequired(false);
    	criteria.setBearingRequired(false);
    	criteria.setCostAllowed(true);
    	criteria.setPowerRequirement(Criteria.POWER_LOW);

    	String provider = locationManager.getBestProvider(criteria, true);
    	
    	Location location = locationManager.getLastKnownLocation(provider);
    	
    	locationManager.requestLocationUpdates(provider,
                60000, // 1min
                100,   // 1km
                locationListener);
    }
    
    private final LocationListener locationListener = new LocationListener() {
    	  public void onLocationChanged(Location location) {
    	    updateWithNewLocation(location);
    	  }

    	  public void onProviderDisabled(String provider){}
    	  public void onProviderEnabled(String provider) {}
    	  public void onStatusChanged(String provider, int status, Bundle extras) {}
    	};
    	
    public void updateWithNewLocation(Location location)
    {
    	if(location != null) {
    		txtLat.setText("lat: " + location.getLatitude());
    		txtLng.setText("lng: " + location.getLongitude());
    	}
    }
}
