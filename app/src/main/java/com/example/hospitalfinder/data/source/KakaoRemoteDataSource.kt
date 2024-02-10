package com.example.hospitalfinder.data.source

import retrofit2.Response

interface KakaoRemoteDataSource {
    suspend fun getSearchHospital(
        x: String, //longitude
        y: String, //latitude
    ): Response<KakaoSearchResponse>
}