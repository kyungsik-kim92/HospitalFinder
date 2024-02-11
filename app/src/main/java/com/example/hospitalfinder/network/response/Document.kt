package com.example.dev_ks.network.response

import net.daum.mf.map.api.MapPOIItem

data class Document(
    val address_name: String,
    val category_group_code: String,
    val category_group_name: String,
    val category_name: String,
    val distance: String,
    val id: String,
    val phone: String,
    val place_name: String,
    val place_url: String,
    val road_address_name: String,
    val x: String,
    val y: String
)

fun Document.toMapPOIItem() : MapPOIItem {
    return MapPOIItem().apply {
        itemName = place_name
        mapPoint = net.daum.mf.map.api.MapPoint.mapPointWithGeoCoord(y.toDouble(), x.toDouble())
        markerType = MapPOIItem.MarkerType.RedPin
        userObject = this@toMapPOIItem
    }
}