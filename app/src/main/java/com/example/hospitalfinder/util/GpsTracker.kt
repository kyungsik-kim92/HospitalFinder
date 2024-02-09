package com.example.hospitalfinder.util

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Task

class GpsTracker(private val application: Application) {

    private val fusedLocationProviderClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(application)
    }

    private var cancellationTokenSource = CancellationTokenSource()

    @SuppressLint("MissingPermission")
    fun getLocation(callback: (Result<Location>) -> Unit) {
        try {
            val currentLocationTask: Task<Location> =
                fusedLocationProviderClient.getCurrentLocation(
                    PRIORITY_HIGH_ACCURACY,
                    cancellationTokenSource.token
                )
            currentLocationTask.addOnSuccessListener {
                callback(Result.Success(it))
            }.addOnFailureListener {
                callback(Result.Error(it))
            }
        } catch (e: Exception) {
            callback(Result.Error(e))
        }
    }

    fun onCancel() {
        cancellationTokenSource.cancel()
    }

}