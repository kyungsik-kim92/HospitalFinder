package com.example.hospitalfinder.network.response

data class Meta(
    val is_end: Boolean,
    val pageable_count: Int,
    val same_name: Any,
    val total_count: Int
)