package com.example.moviestreaming.data.remote.repository.user

import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.repository.user.UserRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.suspendCancellableCoroutine

class UserRepositoryImpl : UserRepository {

    private val userReference = FirebaseHelper.getDatabase().child("users")

    override suspend fun save(user: User) {
        suspendCancellableCoroutine { continuation ->
            userReference.child(FirebaseHelper.getUserId())
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

    override suspend fun getUser(): User {
        return suspendCancellableCoroutine { continuation ->
            userReference.child(FirebaseHelper.getUserId())
                .get().addOnCompleteListener { task ->
                    val user = task.result.getValue(User::class.java)
                    user?.let {
                        continuation.resumeWith(Result.success(it))
                    } ?: run {
                        continuation.resumeWith(Result.failure(Exception("User not found")))
                    }
                }
        }
    }
}