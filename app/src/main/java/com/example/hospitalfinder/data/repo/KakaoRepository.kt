package com.example.hospitalfinder.data.repo

import com.example.hospitalfinder.network.response.KakaoSearchResponse
import retrofit2.Response

interface KakaoRepository {
    suspend fun getSearchHospital(
        x: String, //longitude
        y: String, //latitude
    ): Response<KakaoSearchResponse>
}