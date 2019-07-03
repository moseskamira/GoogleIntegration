package com.example.googlemapintegration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            val firstLocation = LatLng(13.03, 77.60)
            mMap.addMarker(MarkerOptions().position(firstLocation).title("Pick Up Location"))
            mMap.animateCamera(CameraUpdateFactory.newLatLng(firstLocation))
            val secondLocation = LatLng(63.03, 107.60)
            mMap.addMarker(MarkerOptions().position(firstLocation).title("Destination Location"))
            mMap.animateCamera(CameraUpdateFactory.newLatLng(secondLocation))
        })
    }
}
