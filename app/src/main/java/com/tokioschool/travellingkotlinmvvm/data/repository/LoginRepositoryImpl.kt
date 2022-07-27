package com.tokioschool.travellingkotlinmvvm.data.repository
import android.content.Context
import android.util.Log
import com.facebook.AccessToken
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.tokioschool.travellingkotlinmvvm.data.datasource.LoginDatasource
import com.tokioschool.travellingkotlinmvvm.data.mappers.mapToUser
import com.tokioschool.travellingkotlinmvvm.domain.models.User
import com.tokioschool.travellingkotlinmvvm.domain.repository.LoginRepository
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDatasource: LoginDatasource,
    @ApplicationContext private val context:Context,
    private val auth: FirebaseAuth,
) : LoginRepository {

    override fun logIn(userName: String, password: String): Flow<User> =
        loginDatasource.logIn(userName,password).map {it.mapToUser()}

    override fun logInFaceBook(token: AccessToken): Flow<User> = flow{
        kotlin.run {
            val credential= FacebookAuthProvider.getCredential(token.token)
            auth.signInWithCredential(credential).await()?.let { authResult ->
                Log.e("adri","DISPLAYNAME ${authResult.user?.displayName?:"nulo"}")
                Log.e("adri","PHONE-NUMBER ${authResult.user?.phoneNumber?:"nulo"}")
                Log.e("adri","FOTO ${authResult.user?.photoUrl?:"nulo"}")
                Log.e("adri","ADITIONAL-USER-INFO ${authResult.additionalUserInfo?.profile}")
                emit(User(
                    name= (authResult.additionalUserInfo?.profile?.get("first_name")?:"") as String,
                    surName= (authResult.additionalUserInfo?.profile?.get("last_name")?:"") as String,
                    age= -1
                ))
            }
        }
    }
}