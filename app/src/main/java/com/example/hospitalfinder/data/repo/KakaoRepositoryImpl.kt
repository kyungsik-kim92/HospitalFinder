package com.example.hospitalfinder.data.repo

import retrofit2.Response
import javax.inject.Inject

class KakaoRepositoryImpl(private val kakaoRemoteDataSource: KakaoRemoteDataSource) :
    KakaoRepository {

    override suspend fun getSearchHospital(x: String, y: String): Response<KakaoSearchResponse> =
        kakaoRemoteDataSource.getSearchHospital(x = x, y = y)