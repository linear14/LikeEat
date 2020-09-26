package com.fund.likeeat.network

import androidx.room.Delete
import com.fund.likeeat.data.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @GET("/")
    fun requestReview(
    ): Call<List<Review>>

    @POST("/users/login/")
    suspend fun sendUserInfo(
        @Body user: User?
    ): Response<String>

    // POST로 받으니 403 Forbidden (CSRF)
    // 나중에 https://likeeat-server.herokuapp.com/reviews?uid=1234567890 식으로 데이터 가져올 때 사용하면 될듯
    @GET("/reviews/")
    fun requestReviewByUid(
        @Query("uid") uid: Long
    ): Call<List<Review>>

    @GET("/reviews/")
    fun requestUserReview(
        @Query("uid") uid: Long
    ): Call<List<ReviewServerRead>>

    @POST("/reviews/")
    suspend fun addReview(
        @Body reviewNWWrite: ReviewServerWrite?
    ): Response<Unit>

    @PUT("/reviews/{id}")
    suspend fun setReview(
        @Path("id") id: Long,
        @Body reviewNWWrite: ReviewServerWrite?
    ): Response<Unit>

    @DELETE("/reviews/{id}")
    suspend fun deleteReview(
        @Path("id") id: Long
    ): Response<Unit>

    // http://likeeat-server.herokuapp.com/themes/?uid=UID
    @GET("/themes/")
    fun requestThemeByUid(
        @Query("uid") uid: Long
    ): Call<List<Theme>>

    // method: POST
    // url: http://likeeat-server.herokuapp.com/themes/
    @POST("/themes/")
    fun sendTheme(
        @Body theme: ThemeRequest
    ): Call<Theme>

    @PUT("/themes/{id}")
    fun updateTheme(
        @Path("id") id: Long,
        @Body themeChanged: ThemeChanged
    ): Call<Theme>

    @DELETE("/themes/{id}")
    fun deleteTheme(
        @Path("id") id: Long
    ): Call<Theme>

    @PUT("/reviews/{id}")
    fun updateReviewOnlyTheme(
        @Path("id") id: Long,
        @Body reviewChanged: ReviewChanged
    ): Call<Review>

    @POST("/friends/")
    suspend fun addFriends(
        @Body friend: FriendLink
    ): Response<Unit>
}