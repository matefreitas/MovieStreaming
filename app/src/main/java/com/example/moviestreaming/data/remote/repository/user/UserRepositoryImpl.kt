package com.example.moviestreaming.data.remote.repository.user

import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.repository.user.UserRepository
import kotlinx.coroutines.suspendCancellableCoroutine

class UserRepositoryImpl : UserRepository {

    override suspend fun save(user: User) {
        suspendCancellableCoroutine { continuation ->
            FirebaseHelper.getDatabase().child("users").child(FirebaseHelper.getUserId())
                .setValue(user).addOnCompleteListener { task ->
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