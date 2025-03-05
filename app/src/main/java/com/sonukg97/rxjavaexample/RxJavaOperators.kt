package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

val list = mutableListOf(1,2,3,4,5,6,7,8,9,10)
val array = arrayOf(1,2,3,4,5)
val list2 = mutableListOf("Sonu","Rohit","Ronit","Ram","Rohan")
val schedulers =Schedulers.io()
val TAG = MainActivity::class.java.simpleName
fun justOperator(){
    val observable = Observable.just(1,2,3,4,5)
    Log.d(TAG,"Simple Just Operator")
    val observer = object :Observer<Int>{
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

fun justOperatorUsingList(){
    val observable = Observable.just(list)
    Log.d(TAG,"List Just Operator")
    val observer = object :Observer<MutableList<Int>>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: MutableList<Int>) {
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

fun fromArrayOperator(){
    val observable = Observable.fromArray(list2)
    Log.d(TAG,"List From fromArray Operator")
    val observer = object : Observer<MutableList<String>>{

        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: MutableList<String>) {
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

fun fromIterableOperator(){
    val observable = Observable.fromIterable(list2)
    Log.d(TAG,"List From fromIterable Operator")
    val observer = object : Observer<String>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: String) {
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

fun rangeOperator(){
    val observable = Observable.range(1,10)
    Log.d(TAG,"List From range Operator")
    val observer = object : Observer<Int>{
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

fun repeatOperator(){
    val observable = Observable.range(1,10).repeat(2)
    Log.d(TAG,"List From repeat Operator")
    val observer = object : Observer<Int>{
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

fun intervalOperator(){
    val observable = Observable.interval(10,TimeUnit.SECONDS).takeWhile { value-> value <= 10 }
    Log.d(TAG,"List From interval Operator")
    val observer = object : Observer<Long>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: Long) {
            Log.d(TAG,"onNext : $t")
            getLocationsData()
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

fun getLocationsData(){
    val latitute = 230.022
    val longitude = 220.011
    Log.d(TAG,"Latitute : $latitute Longitude : $longitude")
}
