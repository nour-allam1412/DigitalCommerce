package com.depi.myapplicatio.di


import android.app.Application
import android.content.Context.MODE_PRIVATE
import com.depi.myapplicatio.data.remote.FirebaseCommon
import com.depi.myapplicatio.data.remote.FirebaseUtility
import com.depi.myapplicatio.util.constants.Constants.SharedPreferencesConstants.INTRODUCTION_SP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestoreDatabse() = com.google.firebase.ktx.Firebase.firestore


    @Provides
    fun provideIntroductionSP(
        application: Application
    ) = application.getSharedPreferences(INTRODUCTION_SP, MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideFirebaseCommon(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ) = FirebaseCommon(firestore, firebaseAuth)

    @Provides
    @Singleton
    fun provideStorage() = FirebaseStorage.getInstance().reference


    @Provides
    @Singleton
    fun provideFireBaseUtility() = FirebaseUtility(
        provideFirebaseAuth(),
        provideFirebaseFirestoreDatabse()
    )

}