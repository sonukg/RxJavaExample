package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


fun createObservable(){
    val observable = Observable.create<Int> { emitter ->
        try {
            for (i in 1..10){
                emitter.onNext(i)

            }
            emitter.onComplete()
        }catch (e:Exception){
            e.message
        }
    }

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(TAG,"onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }
    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun createSingleObservable(){
    val observable = Single.create<List<User>> { emitter ->
        try {
            emitter.onSuccess(userList)
        }catch (e:Exception){
            e.message
        }
    }

    val observer = object : SingleObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onSuccess(t: List<User>) {
            Log.d(TAG,"onSuccess : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }

    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun createMaybeObservable(){
    val observable = Maybe.create<List<User>> { emitter ->
        try {
            emitter.onSuccess(userList)
            //emitter.onSuccess(emptyList())
        }catch (e:Exception){
            e.message
        }
    }

    val observer = object : MaybeObserver<List<User>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onSuccess(t: List<User>) {
            Log.d(TAG,"onSuccess : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }
        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }

    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun createCompletableObservable(){
    val observable = Completable.create { emitter ->
        try {
            getLocations()
            emitter.onComplete()
        }catch (e:Exception){
            e.message
        }
    }

    val observer = object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }
    }

    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun createFlowableObservable(){
    val flowable = Flowable.fromIterable(userList)

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}


fun getLocations(){
    //throw Exception("Something went wrong")
    Thread.sleep(500)
    val latitute = 230.022
    val longitude = 220.011
    Log.d(TAG,"Latitute : $latitute Longitude : $longitude")
}