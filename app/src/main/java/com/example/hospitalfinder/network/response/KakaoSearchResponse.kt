package com.example.hospitalfinder.network.response

data class KakaoSearchResponse(
    val documents: List<Document>,
    val meta: Meta
)