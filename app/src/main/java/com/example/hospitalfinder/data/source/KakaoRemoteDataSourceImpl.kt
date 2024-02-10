package com.example.hospitalfinder.data.source

import retrofit2.Response
import javax.inject.Inject

class KakaoRemoteDataSourceImpl (private val kakaoService: KakaoService) :
    KakaoRemoteDataSource {


    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoService.getSearchHospital(x = x, y = y)
}