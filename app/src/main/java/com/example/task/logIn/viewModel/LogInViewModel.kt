package com.example.task.logIn.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.base.MyApplication
import com.example.task.base.TinyDB
import com.example.task.logIn.api.APIManger
import com.example.task.logIn.model.LogInResponse
import com.example.task.logIn.model.UserResponse
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking

class LogInViewModel : ViewModel() {
     val loading:MutableStateFlow <Boolean?> = MutableStateFlow(null)
    val userDataList: MutableLiveData<UserResponse> = MutableLiveData()
    val userLoggInDataList: MutableLiveData<LogInResponse> = MutableLiveData()

    var tinyDB =TinyDB(MyApplication.getAppContext())
    private val disposable: CompositeDisposable =CompositeDisposable()

     // log in method and pass the value to  MutableLiveData
     //  add MutableLiveData for loading but did not use due the time
    fun logInUser(mobileNumber:String ,password:Int){
        val single: Single<LogInResponse> = APIManger.getApis()?.logIn(mobileNumber,password)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread()) as Single<LogInResponse>

        val singleObserver: SingleObserver<LogInResponse> =
            object : SingleObserver<LogInResponse> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onSuccess(t:LogInResponse) {
                    userLoggInDataList.postValue(t)
                    if (t.token !=null){
                        tinyDB.putString("token",t.token)

                    }
                    runBlocking {
                        loading.emit(true)

                    }
                    getUserData()
                }

                override fun onError(e: Throwable) {
                   runBlocking {
                       loading.emit(false)

                   }

                }
            }
        single.subscribe(singleObserver)

    }

    // get user data after logged in and pass it to MutableLive data
    fun getUserData(){
        val single: Single<UserResponse> = APIManger.getApis()?.getUserData()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread()) as Single<UserResponse>

        val singleObserver: SingleObserver<UserResponse> =
            object : SingleObserver<UserResponse> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onSuccess(t: UserResponse) {
                    userDataList.postValue(t)
                }

                override fun onError(e: Throwable) {

                }

            }
        single.subscribe(singleObserver)

    }

}