package com.f55119134.modul1;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.f55119134.modul1.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng untad = new LatLng(-0.83643, 119.89369);
        LatLng SMK5 = new LatLng(-0.8436309608577455, 119.90232064678518);

        //Custom Size Marker
        int tinggi = 50;
        int lebar = 50;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.lokasi);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.lokasi2);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(untad).title("Marker in Tadulako University")
                .snippet("this is my University")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(SMK5).title("Marker in SMK5")
                .snippet("this is School")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                untad,
                new LatLng(-0.836532281784805, 119.89314381130023),
                new LatLng(-0.8364750400593068, 119.8914948677698),
                new LatLng(-0.8364958132865281, 119.89099625719687),
                new LatLng( -0.8364411217919471,119.89021453872675),
                new LatLng(-0.8372426592374328, 119.88966820973029),
                new LatLng(-0.8380952498435219, 119.88985202135527),
                new LatLng(-0.8385343084365328, 119.88993882130283),
                new LatLng(-0.8400199597420287, 119.89020432699719),
                new LatLng(-0.8417864035277732, 119.89055152676225),
                new LatLng(-0.8433945814166897, 119.89092425591267),
                new LatLng(-0.8434201240508793, 119.89227689105348),
                new LatLng(-0.8434201240586143, 119.89493194804173),
                new LatLng(-0.8434405453607424, 119.89863371005491),
                new LatLng(-0.8435018092636662, 119.90112027298882),
                new LatLng(-0.843576893096476, 119.90210734925171),
                new LatLng(-0.8438879956014362, 119.90227901061958),
                SMK5
                ).width(10)
                .color(Color.GREEN)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(untad, 11.5f));
    }
}