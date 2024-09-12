package com.mnp.bluedot.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.mnp.bluedot.MapSate

@Composable
fun MapScreen(
    state: MapSate,
) {
    val mapProperties = MapProperties(
        isMyLocationEnabled = state.lastKnownLocation != null
    )
    GoogleMap(
        properties = mapProperties,
    )
}