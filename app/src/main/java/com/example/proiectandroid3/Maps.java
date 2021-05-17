package com.example.proiectandroid3;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.URI;

public class Maps extends FragmentActivity implements OnMapReadyCallback  {
    private static final int ERROR_DIALOG_REQUEST = 9001;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DesenPieChart(this));
        setContentView(R.layout.about_us);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng sts = new LatLng(44.443311, 26.038227);
        LatLng mta = new LatLng(44.418248, 26.086430);
        map.addMarker(new MarkerOptions().position(sts).title("STS"));
        map.addMarker(new MarkerOptions().position(mta).title("MTA"));

        map.moveCamera(CameraUpdateFactory.newLatLng(sts));
        map.moveCamera(CameraUpdateFactory.newLatLng(mta));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(mta, 12.0f));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(sts, 12.0f));
    }
}