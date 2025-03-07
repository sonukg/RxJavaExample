package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable

fun hotObservable(){
    val observable = ConnectableObservable.create<User> {
        emitter ->
        try {
            for (user in userList) {
                emitter.onNext(user)
            }
        }catch (e:Exception){
            emitter.onError(e)
        }
    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            user ->
            Log.d(TAG,"onNext : ${user.name}, ${user.email}, ${user.age}")
        },{
            error ->
            Log.d(TAG,"onError : ${error.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    val hotObservable = observable.publish()
    hotObservable.connect()
}