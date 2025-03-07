package com.sonukg97.rxjavaexample

import android.os.Handler
import android.os.Looper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/*RxJava 3 Schedulers
These are the core schedulers provided by RxJava 3:

Schedulers.io():

Used for IO-bound work (e.g., network calls, file operations).

Backed by a thread pool that can grow as needed.

Schedulers.computation():

Used for CPU-intensive work (e.g., data processing, calculations).

Thread pool size is limited to the number of CPU cores.

Schedulers.newThread():

Creates a new thread for each subscription.

Not recommended for frequent or repeated tasks due to high overhead.

Schedulers.single():

Uses a single thread for all tasks.

Useful for sequential execution.

Schedulers.trampoline():

Executes tasks on the current thread in a FIFO (First-In-First-Out) manner.

Useful for testing or avoiding thread switching.

Schedulers.from(Executor):

Allows you to create a custom scheduler from an Executor.

RxAndroid 3 Schedulers
RxAndroid provides Android-specific schedulers:

AndroidSchedulers.mainThread():

Executes tasks on the Android main (UI) thread.

Used for updating the UI after background work.

AndroidSchedulers.from(Looper):

Executes tasks on a specific Looper thread (e.g., a background thread with a Handler).*/

fun ioAndMainScheduler(){
    Observable.create<String> { emitter ->
        Thread.sleep(2000)
        emitter.onNext("Data from network")
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { data -> println("Received data: $data on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") }
        )
}

fun computationScheduler(){
    Observable.create<Int> { emitter ->
        val result = (1..100).sum()
        emitter.onNext(result)
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.computation())
        .subscribe(
            { result -> println("Sum: $result on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") }
        )
}

fun newThreadScheduler(){
    Observable.create<String> { emitter ->
        emitter.onNext("Running on a new thread")
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.newThread())
        .subscribe(
            { data -> println("$data on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") }
        )
}

fun trumpoLineScheduler(){
    Observable.create<String> { emitter ->
        emitter.onNext("Task 1")
        emitter.onNext("Task 2")
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.trampoline())
        .subscribe(
            { data -> println("$data on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") }
        )
}

fun fromLooperScheduler(){
    val backgroundLooper = Handler(Looper.getMainLooper()).looper

    Observable.create<String> { emitter ->

        emitter.onNext("Running on custom Looper")
        emitter.onComplete()
    }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.from(backgroundLooper))
        .subscribe(
            { data -> println("$data on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") }
        )
}

fun singleScheduler() {
    println("Main thread: ${Thread.currentThread().name}")

    val observable = Observable.create<String> { emitter ->
        for (i in 1..3) {
            try {
                Thread.sleep(500)
                emitter.onNext("Item $i")
            } catch (e: InterruptedException) {
                emitter.onError(e)
            }
        }
        emitter.onComplete()
    }


    observable
        .subscribeOn(Schedulers.single())
        .observeOn(Schedulers.io())
        .subscribe(
            { item -> println("Received: $item on ${Thread.currentThread().name}") },
            { error -> println("Error: ${error.message}") },
            { println("Completed on ${Thread.currentThread().name}") }
        )

    // Keep the main thread alive to observe the output
    Thread.sleep(3000)
}

