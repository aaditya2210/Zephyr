package com.example.voltify;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{

    FrameLayout map;
    GoogleMap gMap;
    Location currentLocation;
    Marker marker;
    FusedLocationProviderClient fusedClient;
    private static final int REQUEST_CODE = 101;
    SearchView searchView;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map = findViewById(R.id.map);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();

        fusedClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String loc = searchView.getQuery().toString();
                if (loc == null){
                    Toast.makeText(MapActivity.this, "Location Not Found", Toast.LENGTH_SHORT).show();
                } else {
                    Geocoder geocoder = new Geocoder(MapActivity.this, Locale.getDefault());
                    try {
                        List<Address> addressList = geocoder.getFromLocationName(loc, 1);
                        if (addressList.size() > 0){
                            LatLng latLng = new LatLng(addressList.get(0).getLatitude(),addressList.get(0).getLongitude());
                            if (marker != null){
                                marker.remove();
                            }
                            MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(loc);
                            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


//

//                            final LatLng melbourneLocation = new LatLng(-37.813, 144.962);
//                            Marker melbourne = map.addMarker(
//                                    new MarkerOptions()
//                                            .position(melbourneLocation)
//                                            .title("Melbourne")
//                                            .snippet("Population: 4,137,400")
//                                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)));

//
                            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,5);
                            gMap.animateCamera(cameraUpdate);
                            marker = gMap.addMarker(markerOptions);
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }

        Task<Location> task = fusedClient.getLastLocation();

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null) {
                    currentLocation = location;
                    //Toast.makeText(getApplicationContext(), currentLocation.getLatitude() + "" + currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(MapActivity.this);
                }

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Log.e("onMapReady", "value of onMapReady ");
        //Deeps code start 1


        List<DataClass> dataList;
        MyAdapter adapter;

        dataList =  new ArrayList<>();
//
        this.gMap = googleMap;
        adapter = new MyAdapter(MapActivity.this, dataList);
        databaseReference = FirebaseDatabase.getInstance().getReference("Android Tutorials");

        Log.e("databaseReference", "value of databaseReference " + databaseReference);
        // Attach a listener to read the data at our posts reference

        ValueEventListener vel = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for( DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DataClass dataClass = dataSnapshot.getValue(DataClass.class);
                    Log.e("dataSnapshot", "value of dataSnapshot " + dataSnapshot);
                    Log.e("dataClass", "value of dataClass " + dataClass);
                    if (dataClass != null) {
                        Log.e("datalist1", "value of lng " + dataClass.getLng());
                        Log.e("datalist2", "value of lat " + dataClass.getLtd());
                        String DB_lng = dataClass.getLng();
                        String DB_lat = dataClass.getLtd();

                        ////////
                        if( DB_lng != null && DB_lat != null ) {
                            LatLng latLng1 = new LatLng(Double.parseDouble(DB_lat), Double.parseDouble(DB_lng));
                            MarkerOptions markerOptions1 = new MarkerOptions().position(latLng1).title("Station: " +dataClass.getDataTitle()).snippet("Ports: "+dataClass.getDataDesc())
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_logoev6));
                            googleMap.addMarker(markerOptions1);
                        }
                        //////////

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("The read failed: " + error.getCode());
            }
        };

        databaseReference.addValueEventListener(vel);

        //Deeps code start 1


        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("My Current Location");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 7 ));
        googleMap.addMarker(markerOptions);

        //Deeps code start 2
//        double lat = 18.922064;
//        double lng = 72.834641;
//        LatLng latLng1 = new LatLng( lat, lng);
//        MarkerOptions markerOptions1 = new MarkerOptions().position(latLng1).title("Charger 1").snippet("Population: 4,137,400")
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_logoev4));
//        googleMap.addMarker(markerOptions1);
        //Deeps code end 2

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            }
        }
    }
}