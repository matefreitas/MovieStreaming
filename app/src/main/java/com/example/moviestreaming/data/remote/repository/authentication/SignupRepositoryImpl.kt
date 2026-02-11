package com.example.moviestreaming.data.remote.repository.authentication

import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.repository.authentication.SignupRepository
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class SignupRepositoryImpl : SignupRepository {

    override suspend fun register(email: String, password: String) {
        return suspendCoroutine { continuation ->
            FirebaseHelper.getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        continuation.resumeWith(Result.success(Unit))
                    } else{
                        task.exception?.let {
                            continuation.resumeWith(Result.failure(it))
                        }
                    }
                }
        }
    }

}