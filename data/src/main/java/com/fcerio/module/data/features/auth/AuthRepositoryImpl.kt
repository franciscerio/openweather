package com.fcerio.module.data.features.auth

import com.fcerio.module.domain.user.User
import com.fcerio.module.network.features.auth.AuthRemoteSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteSource: AuthRemoteSource
) : AuthRepository {

    override suspend fun singIn(email: String, password: String): User {
        return User(1, email, "")
    }

    override suspend fun register(email: String, password: String): User {
        return User(1, email, "")
    }
}