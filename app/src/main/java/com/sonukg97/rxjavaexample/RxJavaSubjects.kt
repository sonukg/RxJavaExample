package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

fun asyncSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <=10 }
    val subject = AsyncSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })
}

fun asyncSubjectTwo(){
    val subject = AsyncSubject.create<Int>()
    subject.onNext(10)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.onComplete()
}

fun asyncSubjectThree(){
    val observable = Observable.fromIterable(userList)
    val subject = AsyncSubject.create<User>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

}

fun behaviorSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <=10 }
    val subject = BehaviorSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })
}

fun behaviorSubjectTwo(){
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(10)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.onNext(11)
    subject.onNext(12)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.onNext(13)
    subject.onNext(14)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })
}

fun behaviorSubjectThree(){
    val observable = Observable.fromIterable(userList)
    val subject = BehaviorSubject.create<User>()
    observable
        .subscribeOn(schedulers)
        .subscribe(subject)

    subject
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : ${it.name}, ${it.email}, ${it.age}")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

}

fun publishSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <=10 }
    val subject = PublishSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })
}

fun publishSubjectTwo(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <=10 }
    val subject = PublishSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext2 : $it")
        },{
            Log.d(TAG,"onError2 : ${it.message}")
        },{
            Log.d(TAG,"onComplete2")
        })

    //subject.onComplete()
}

fun publishSubjectThree(){
    val subject = PublishSubject.create<User>()
    val observable = Observable.fromIterable(userList)

    observable.subscribeOn(schedulers)
        .subscribe(subject)

    subject
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : ${it.name}, ${it.email}, ${it.age}")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

}

fun replaySubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <=10 }
    val subject = ReplaySubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext2 : $it")
        },{
            Log.d(TAG,"onError2 : ${it.message}")
        },{
            Log.d(TAG,"onComplete2")
        })
}

fun replaySubjectTwo(){
    val subject = ReplaySubject.create<Int>()
    subject.onNext(10)
    subject.onNext(11)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext : $it")
        },{
            Log.d(TAG,"onError : ${it.message}")
        },{
            Log.d(TAG,"onComplete")
        })

    subject.onNext(12)
    subject.onNext(13)
    subject.onNext(14)

    subject.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d(TAG,"onNext2 : $it")
        },{
            Log.d(TAG,"onError2 : ${it.message}")
        },{
            Log.d(TAG,"onComplete2")
        })


}