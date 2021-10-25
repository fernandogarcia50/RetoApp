package com.example.myapplication

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.GenCoordenadas.setOnClickListener(){
            if(!binding.DatoCiudad.text.isEmpty()) {
                val geocoder = Geocoder(this, Locale.getDefault())
                val direccion: List<Address> =
                    geocoder.getFromLocationName(binding.DatoCiudad.text.toString(), 1)
            if (direccion[0].hasLatitude() && direccion[0].hasLongitude()) {
                binding.mostrarLatitud.setText("${direccion[0].latitude}")
                binding.mostrarLongitud.setText("${direccion[0].longitude}")
                binding.MostrarCiudad.setText("Ciudad:  ${binding.DatoCiudad.text}")
                binding.DatoCiudad.text.clear()
            }
            }
        }
    }
}