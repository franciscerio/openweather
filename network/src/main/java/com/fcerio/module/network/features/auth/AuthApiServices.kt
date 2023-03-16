package com.fcerio.module.network.features.auth

import com.fcerio.module.network.features.auth.models.UserDTO
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthApiServices {

    @POST("auth/register")
    suspend fun register(@Body registerBody: RequestBody): UserDTO

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun signIn(@Body registerBody: RequestBody): UserDTO
}
