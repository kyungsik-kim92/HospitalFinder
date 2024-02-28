package com.example.hospitalfinder.data.source.remote

import com.example.hospitalfinder.network.response.KakaoSearchResponse
import com.example.hospitalfinder.network.KakaoService
import retrofit2.Response

class KakaoRemoteDataSourceImpl (private val kakaoService: KakaoService) :
    KakaoRemoteDataSource {


    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoService.getSearchHospital(x = x, y = y)
}