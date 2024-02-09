package com.example.hospitalfinder.data.repo

import retrofit2.Response

interface KakaoRepository {
    suspend fun getSearchHospital(
        x: String, //longitude
        y: String, //latitude
    ): Response<KakaoSearchResponse>
}