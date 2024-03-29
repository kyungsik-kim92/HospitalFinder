package com.example.hospitalfinder.data.repo

import com.example.hospitalfinder.network.response.KakaoSearchResponse
import com.example.hospitalfinder.data.source.remote.KakaoRemoteDataSource
import retrofit2.Response

class KakaoRepositoryImpl(private val kakaoRemoteDataSource: KakaoRemoteDataSource) :
    KakaoRepository {

    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoRemoteDataSource.getSearchHospital(x = x, y = y)
}