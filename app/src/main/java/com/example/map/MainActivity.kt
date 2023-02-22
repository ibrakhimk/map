package com.example.map

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.map.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey("bb16f71f-e8b1-416e-818e-01e0c0251da3")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        MapKitFactory.initialize(this)
        setContentView(view)
        binding.mapView.map.move(CameraPosition(com.yandex.mapkit.geometry.
        Point(42.8657121,74.6161478),19.0f,0.0f,0.0f),
        Animation(Animation.Type.SMOOTH,10f),null)
        var mapKit: MapKit = MapKitFactory.getInstance()
        requstLocationPermission()
        var probki = mapKit.createTrafficLayer(binding.mapView.mapWindow)
        probki.isTrafficVisible = true
//        var locationOnMapKit = mapKit.createUserLocationLayer(binding.mapView.mapWindow)
//        locationOnMapKit.isVisible = true
        var locationmapkit = mapKit.createUserLocationLayer(binding.mapView.mapWindow)
        locationmapkit.isVisible = true
    }
//    private fun requstLocationPermission(){
//        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION), 0)
//            return
//        }
//    }
    private fun requstLocationPermission() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
     ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),0)
            return
        }
    }
    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        binding.mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}