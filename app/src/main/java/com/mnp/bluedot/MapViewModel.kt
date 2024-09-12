package com.mnp.bluedot

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel  @Inject constructor(): ViewModel(){

    val state: MutableState<MapSate> = mutableStateOf(MapSate(null))

    @SuppressLint("MissingPermission")
    fun getDeviceLocation(
        fusedLocationProviderClient: FusedLocationProviderClient
    ){
        val locationProviderClient = fusedLocationProviderClient.lastLocation
        locationProviderClient.addOnSuccessListener { task ->
            if (task != null) {
                state.value = state.value.copy(
                    lastKnownLocation = task
                )
            }
        }
    }
}