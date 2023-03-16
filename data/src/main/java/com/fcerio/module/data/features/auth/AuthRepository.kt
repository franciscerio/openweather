package com.fcerio.module.data.features.auth

import com.fcerio.module.domain.user.User

interface AuthRepository {
    suspend fun singIn(email: String, password: String): User
    suspend fun register(
        email: String, password: String
    ): User
}