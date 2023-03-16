package com.fcerio.module.network.features.auth

import com.fcerio.module.domain.user.User
import com.fcerio.module.network.base.BaseRemoteSource
import javax.inject.Inject

class AuthRemoteSourceImpl @Inject constructor(
    private val apiServices: AuthApiServices
) : BaseRemoteSource(), AuthRemoteSource {

    override suspend fun signIn(email: String, password: String): User {
        return User(1, email, "John Doe")
    }

    override suspend fun register(email: String, password: String, fullName: String): User {
        return User(1, email, fullName)
    }
}

