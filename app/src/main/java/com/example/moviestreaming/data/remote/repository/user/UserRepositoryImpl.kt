package com.example.moviestreaming.data.remote.repository.user

import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.repository.user.UserRepository
import kotlin.coroutines.suspendCoroutine

class UserRepositoryImpl : UserRepository {

    private val userReference =
        FirebaseHelper.getDatabase().child("users").child(FirebaseHelper.getUserId())

    override suspend fun save(user: User) {
        suspendCoroutine { continuation ->
            userReference.setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resumeWith(Result.success(Unit))
                } else {
                    task.exception?.let {
                        continuation.resumeWith(Result.failure(it))
                    }
                }
            }
        }
    }
}