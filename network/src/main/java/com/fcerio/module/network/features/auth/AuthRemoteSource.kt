package com.fcerio.module.network.features.auth

import com.fcerio.module.domain.user.User

interface AuthRemoteSource {
    suspend fun signIn(email: String, password: String): User
    suspend fun register(email: String, password: String, fullName: String): User
}