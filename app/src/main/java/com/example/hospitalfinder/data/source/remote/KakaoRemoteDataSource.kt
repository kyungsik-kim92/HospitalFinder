package com.example.hospitalfinder.data.source.remote


import com.example.hospitalfinder.network.response.KakaoSearchResponse
import retrofit2.Response

interface KakaoRemoteDataSource {
    suspend fun getSearchHospital(
        x: String, //longitude
        y: String, //latitude
    ): Response<KakaoSearchResponse>
}