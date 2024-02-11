package com.example.hospitalfinder.data.repo

import com.example.dev_ks.network.response.KakaoSearchResponse
import com.example.hospitalfinder.data.source.KakaoRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class KakaoRepositoryImpl(private val kakaoRemoteDataSource: KakaoRemoteDataSource) :
    KakaoRepository {

    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoRemoteDataSource.getSearchHospital(x = x, y = y)
}