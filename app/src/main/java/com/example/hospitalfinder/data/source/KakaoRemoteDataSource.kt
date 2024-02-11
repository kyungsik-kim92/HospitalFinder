package com.example.hospitalfinder.data.source

import com.example.dev_ks.network.response.KakaoSearchResponse
import retrofit2.Response

interface KakaoRemoteDataSource {
    suspend fun getSearchHospital(
        x: String, //longitude
        y: String, //latitude
    ): Response<KakaoSearchResponse>
}