package com.fund.likeeat.network

import com.fund.likeeat.data.Place
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitKaKaoService {

    @Headers("Authorization: KakaoAK 0d32d9da9b3c910fc0b6b91015428cb1")
    @GET("/v2/local/search/keyword.json?category_group_code=FD6")
    suspend fun getPlace(
        @Query("query") searchWord: String
    ): Response<KaKaoRetrofit.KakaoSearchPlaceResult>

}