package com.example.moviestreaming.data.remote.repository.authentication

import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.repository.authentication.AuthenticationRepository
import kotlinx.coroutines.suspendCancellableCoroutine

class AuthenticationRepositoryImpl : AuthenticationRepository {

    override suspend fun register(email: String, password: String) {
        return suspendCancellableCoroutine { continuation ->
            FirebaseHelper.getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
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

    override suspend fun login(email: String, password: String) {
        return suspendCancellableCoroutine { continuation ->
            FirebaseHelper.getAuth().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
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