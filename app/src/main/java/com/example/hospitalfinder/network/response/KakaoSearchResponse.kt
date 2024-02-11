package com.example.dev_ks.network.response

data class KakaoSearchResponse(
    val documents: List<Document>,
    val meta: Meta
)