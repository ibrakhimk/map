package com.example.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.map.databinding.FragmentMapsBinding
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView


class MapsFragment : Fragment() {

    lateinit var mapView: MapView
    private lateinit var binding: FragmentMapsBinding;

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentMapsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        MapKitFactory.setApiKey("bb16f71f-e8b1-416e-818e-01e0c0251da3")
//        MapKitFactory.initialize(this)
    }
}