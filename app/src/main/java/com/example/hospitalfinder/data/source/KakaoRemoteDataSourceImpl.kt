package com.example.hospitalfinder.data.source

import com.example.dev_ks.network.response.KakaoSearchResponse
import com.example.hospitalfinder.network.KakaoService
import retrofit2.Response
import javax.inject.Inject

class KakaoRemoteDataSourceImpl (private val kakaoService: KakaoService) :
    KakaoRemoteDataSource {


    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoService.getSearchHospital(x = x, y = y)
}