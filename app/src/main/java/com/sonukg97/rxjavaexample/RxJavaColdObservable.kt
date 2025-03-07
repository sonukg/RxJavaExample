package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

// for any cold observable we must have to subscribe to the observable else it will not be executed

fun coldObservable(){
    val observable = Observable.create<User> { emitter ->
        try {
            for (user in userList) {
                emitter.onNext(user)
            }
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    val observer = object : Observer<User> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG, "onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG, "onNext : ${t.name}, ${t.email}, ${t.age}")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError : ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG, "onComplete")
        }
    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}