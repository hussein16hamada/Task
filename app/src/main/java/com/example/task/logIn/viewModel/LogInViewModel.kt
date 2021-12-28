package com.example.task.logIn.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.logIn.api.APIManger
import com.example.task.logIn.model.LogInModel
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.ArrayList
import java.util.concurrent.Flow

class LogInViewModel : ViewModel() {
     val message: MutableLiveData<Boolean> = MutableLiveData()
    val userDataList: MutableLiveData<Boolean> = MutableLiveData()

    private val disposable: CompositeDisposable =CompositeDisposable()


    fun logInUser(mobileNumber:Int ,password:Int){
        val single: Single<Any> = APIManger.getApis().logIn(mobileNumber,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val singleObserver: SingleObserver<Any> =
            object : SingleObserver<Any> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onSuccess(t:Any) {
                    Log.d("eeeeeeees", t.toString())
                    message.postValue(true)
                    getUserData()
                }

                override fun onError(e: Throwable) {

                    message.postValue(false)
                    Log.d("eeeeeeeef", e.localizedMessage)

                }
            }
        single.subscribe(singleObserver)

    }

    fun getUserData(){
        val single: Single<Any> = APIManger.getApis().getUserData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val singleObserver: SingleObserver<Any> =
            object : SingleObserver<Any> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onSuccess(t: Any) {
                    Log.d("eeeeeeeeus", t.toString())

                }

                override fun onError(e: Throwable) {
                    Log.d("eeeeeeeeuf", e.localizedMessage)

                }

            }
        single.subscribe(singleObserver)

    }

}