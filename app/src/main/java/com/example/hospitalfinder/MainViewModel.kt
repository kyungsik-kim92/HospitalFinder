package com.example.hospitalfinder

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hospitalfinder.data.repo.KakaoRepository
import com.example.hospitalfinder.util.GpsTracker
import kotlinx.coroutines.Dispatchers
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint

class MainViewModel(private val application: Application, private val kakaoRepository: KakaoRepository) : ViewModel() {

    private val cacheMapPOIItem = mutableMapOf<String, MapPOIItem>()

    private var currentMapCenterPoint: MapPoint? = null
    init {
        getMyLocation()
    }

    fun getMyLocation() {

        viewModelScope.launch(Dispatchers.IO) {

            GpsTracker(application).getLocation { result ->

                when (result) {
                    is Result.Error -> {
                        Log.d("결과1", result.exception.toString())
                    }

                    is Result.Success -> {

                        val currentMapPoint = MapPoint.mapPointWithGeoCoord(
                            result.data.latitude,
                            result.data.longitude
                        )

                        onChangedViewState(MainViewState.GetCurrentLocation(currentMapPoint))

                        searchHospital(
                            result.data.longitude.toString(),
                            result.data.latitude.toString()
                        )
                    }
                }
            }
        }
    }

    fun getSearchAround() {

        currentMapCenterPoint?.let {
            val x = it.mapPointGeoCoord.longitude.toString()
            val y = it.mapPointGeoCoord.latitude.toString()
            searchHospital(x, y)
        }

    }

    private fun searchHospital(x: String, y: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val response = kakaoRepository.getSearchHospital(x, y)

            cacheMapPOIItem.clear()

            if (response.isSuccessful) {
                val getHospitalList = response.body()?.documents?.map { it.toMapPOIItem() }
                    ?.toTypedArray() ?: emptyArray()

                getHospitalList.forEach {
                    cacheMapPOIItem[it.itemName] = it
                }
                onChangedViewState(MainViewState.GetSearchHospital(cacheMapPOIItem.values.toTypedArray()))
            } else {
                Log.d("결과", response.errorBody().toString())
                Log.d("결과", response.message())
            }
        }
    }

    sealed class MainViewState {
        data class GetCurrentLocation(val point: MapPoint) : MainViewState()

        data class GetSearchHospital(val items: Array<MapPOIItem>) : MainViewState()
    }
}