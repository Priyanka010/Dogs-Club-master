package com.manishab.straydogsapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.manishab.straydogsapp.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    LocationManager lm;
    LocationListener ll;
    Location l;
    LatLng pos;
    Marker marker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        ll = new LocationListener() {


            @Override
            public void onLocationChanged(Location location) {
                if (marker != null) {
                    marker.remove();
                }
                // marker = mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude())));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

        };
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //do nothing
        } else {
            //enable loation
            AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Activate GPS").setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            }).setMessage("Please activate GPS");
            builder.create().show();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //mapFragment.getMap();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            lm.requestLocationUpdates(lm.NETWORK_PROVIDER, 0, 0, ll);
        }

        // pos = new LatLng(l.getLatitude(), l.getLongitude());

        // Add a marker in Sydney and move the camera
        mMap.setMyLocationEnabled(true);
        // mMap.addMarker(new MarkerOptions().position(pos).title("Marker in Nepal"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.6651332,85.295459)).title("Dakchhinkali Road, Kirtipur").snippet("Animal Nepal(AN), Contact : 015538068, 9841334537"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.6520573,85.2903199)).title("Across Jalbinayak Temple, Chobar, Lalitpur, Nepal").snippet("Sneha's Care, Contact : 980-1205076"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.7192057,85.3493023)).title("Chucchepati, Chabahil, Kathmandu, Nepal").snippet("Animal Medical Centre, Contact : +977-9843544022, 014480625"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.7722853,85.361892)).title("Budhanilkantha, kathmandu, Nepal").snippet("Kathmandu Anmimal Treatment Centre (KAT), Contact : 01-4377729"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.721378,85.3597512)).title("Boudha, Kathmandu,Nepal").snippet("Street Dog Care (SDC), Contact : 9841075383"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.6481885,85.4071521)).title("Gapali-12, Suryabinayak, Bhaktapur").snippet("Bhaktapur Animal Welfare Society (BAWS), Contact : +977-01-6613244/ 9751008067"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.705404,85.3244805)).title("Dillibazar,Kathmandu, Nepal").snippet(", Contact : +977-01-6613244/ 9751008067"));/*
        Add a marker in Sydney and move the camera\\
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos,16));
        */

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0,ll);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = lm.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            // Getting latitude of the current location
            double latitude = location.getLatitude();

            // Getting longitude of the current location
            double longitude = location.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude, longitude);

            googleMap.addMarker(new MarkerOptions().position(latLng).title("Current Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.imageeee)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));

        }

    }

}