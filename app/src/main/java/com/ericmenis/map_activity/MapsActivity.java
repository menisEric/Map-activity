package com.ericmenis.map_activity;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    private Geocoder geocoder;
    private List<Address> addresses;

    private MarkerOptions marker;

    private Double latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            latitud = bundle.getDouble("latitud");
            longitud = bundle.getDouble("longitud");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng lugar = new LatLng(latitud, longitud);

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);

        marker = new MarkerOptions();
        marker.position(lugar);
        marker.title("Mi lugar");
        marker.draggable(true);
        marker.icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_on));

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lugar));
        mMap.animateCamera(zoom);

        mMap.setOnMarkerDragListener(this);

        geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        latitud = marker.getPosition().latitude;
        longitud = marker.getPosition().longitude;

        try {
            addresses = geocoder.getFromLocation(latitud, longitud, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String address = addresses.get(0).getAddressLine(0);
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();

        marker.setSnippet(address);
        marker.showInfoWindow();
    }
}
