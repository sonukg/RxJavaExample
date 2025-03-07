package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

fun flowableBufferBackpressure() {
    val flowable = Flowable.fromIterable(userList)
        .onBackpressureBuffer()

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation(), false, 1)
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
                Thread.sleep(10)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun flowableDropBackpressure() {
    val flowable = Flowable.fromIterable(userList)
        .onBackpressureDrop { user ->
            Log.d(TAG, "Dropped: ${user.name}")
        }

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation(), false, 16)
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
                Thread.sleep(10)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun flowableLatestBackpressure() {
    val flowable = Flowable.fromIterable(userList)
        .onBackpressureLatest()

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation(), false, 16)
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
                Thread.sleep(10)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun flowableErrorBackpressure() {
    val flowable = Flowable.create({ emitter ->
        userList.forEach { user ->
            emitter.onNext(user)
        }
        emitter.onComplete()
    }, BackpressureStrategy.ERROR)

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation(), false, 16)
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
                Thread.sleep(10)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )

}

fun flowableMissingBackpressure() {
    val flowable = Flowable.create({ emitter ->
        userList.forEach { user ->
            emitter.onNext(user)
        }
        emitter.onComplete()
    }, BackpressureStrategy.MISSING)

    flowable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation(), false, 16)
        .subscribe(
            { user ->
                Log.d(TAG, "User: ${user.name}, Email: ${user.email}, Age: ${user.age}")
                Thread.sleep(10)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}