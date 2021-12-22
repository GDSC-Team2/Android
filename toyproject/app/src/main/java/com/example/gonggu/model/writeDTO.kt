package com.example.gonggu.model

import com.google.gson.annotations.SerializedName

//글 등록 API DTO
data class writeDTO(
    @SerializedName("author") var author: String?=null,
    @SerializedName("contact") var contact: String?=null,
    @SerializedName("date") var date: String?=null,
    @SerializedName("description") var description: String?=null,
    @SerializedName("link") var link: String?=null,
    @SerializedName("price") var price: String?=null,
    @SerializedName("title") var title: String?=null
)
