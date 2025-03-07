package com.sonukg97.rxjavaexample

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

val list = mutableListOf(1,2,3,4,5,6,7,8,9,10)
val array = arrayOf(1,2,3,4,5)
val list2 = mutableListOf("Sonu","Rohit","Ronit","Ram","Rohan")
val userList = mutableListOf<User>(
    User(1,"Sonu","william.paterson@my-own-personal-domain.com",22),
    User(2,"Rohit","james.francis.byrnes@example-pet-store.com",22),
    User(3,"Ronit","ronit876@hotmail.com",22),
    User(4,"Ram","Ram1989@gmail.com",25),)

val userDetailsList = mutableListOf<UserDetails>(
    UserDetails(9876543210,987654420,"Ashok Vihar","Delhi","Delhi",110092,"India"),
    UserDetails(9876543910,987654620,"Palak Vihar","Delhi","Delhi",110082,"India"),
    UserDetails(9876543810,987654220,"Ramji Nagar","Delhi","Delhi",110072,"India"),
    UserDetails(9876543710,987654320,"Salimar bag","Delhi","Delhi",110032,"India")
)

val defaultUser = User(0, "Default User", "default@example.com", 0)
val defaultUserDetails = UserDetails(0, 0, "Default Address", "Default City", "Default State", 0, "Default Country")

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

fun timerOperator(){
    val observable = Observable.timer(5,TimeUnit.SECONDS)
    Log.d(TAG,"List From timer Operator")
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

fun createOperator(){
    val observable = Observable.create<Int> {
        try {
            for (i in list){
                it.onNext(i * 5)
                Thread.sleep(1000)
            }

            it.onComplete()

        }catch (e:Exception){
            it.onError(e)
        }
    }

    Log.d(TAG,"Data from createOperator")

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

fun filterOperator(){
    val observable = Observable.fromIterable(userList).filter { user -> user.age > 22 }
    Log.d(TAG,"Data from filterOperator")
    val observer = object : Observer<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: User) {
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

fun lastOperator(){
    val observable = Observable.fromIterable(userList).last(User(1,"Sonu Kumar","sonukg97@gmail.com",23))
    Log.d(TAG,"Data from lastOperator")
    val observer = object : SingleObserver<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onSuccess(t: User) {
            Log.d(TAG,"onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }
    }
    observable.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun distinctOperator(){
    val observable = Observable.fromIterable(userList).distinct{age -> age.age}
    Log.d(TAG,"Data from distinct Operator")
    val observer = object : Observer<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: User) {
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

fun skipOperator(){
    val observable0 = Observable.fromIterable(userList).skip(2)
    val observable1 = Observable.fromIterable(userList).skip(2).distinct{age -> age.age}
    val observable2 = Observable.fromIterable(userList).skipLast(2)
    val observable3 = Observable.fromIterable(userList).skipLast(3,TimeUnit.MILLISECONDS)
    Log.d(TAG,"Data from skipOperator")
    val observer = object : Observer<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG,"onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }
    }
    observable0.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)

    observable1.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)

    observable2.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)

    observable3.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

fun bufferOperator(){
    val observable = Observable.fromIterable(userList).buffer(2)
    Log.d(TAG,"Data from distinctOperator")
    val observer = object : Observer<MutableList<User>>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: MutableList<User>) {
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

fun mapOperator(){
    val observable0 = Observable.fromIterable(list).map { it *10 }
    val observable1 = Observable.fromIterable(userList).map { user-> User(user.id,user.name,user.email,24,) }
    Log.d(TAG,"Data from distinctOperator")
    val observer0 = object : Observer<Int>{
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

    val observer1 = object : Observer<User>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: User) {
            Log.d(TAG,"onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : ${e.message}")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }
    }
    observable0.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer0)

    observable1.subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer1)
}

fun flatMapOperator(){
    val observable = Observable.fromIterable(userList)
    observable.flatMap { user-> fetchUser(user.id).subscribeOn(schedulers) }
        .subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({userList ->
            Log.d(TAG,"Received Data $userList")
        },{error->
            Log.d(TAG,"onError: ${error.message}")
        },{
            Log.d(TAG,"onComplete")
        })
}

fun groupByOperator(){
    val observable = Observable.fromIterable(userList)
    val observable1 = Observable.fromIterable(userList)
    /*observable.groupBy { user-> user.age }
        .subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({groupbyObservable ->
            Log.d(TAG,"Group ${groupbyObservable.key}")
            groupbyObservable.subscribe{user->
                Log.d(TAG, "User: ${user.name} (Age: ${user.age})")
            }

        },{error->
            Log.d(TAG,"onError: ${error.message}")
        },{
            Log.d(TAG,"onComplete")
        })*/

    observable1
        .groupBy { user -> user.age }
        .flatMap { groupedObservable ->
            groupedObservable
                .toList()
                .toObservable()
                .map { users ->
                    "Group ${groupedObservable.key}: ${users.joinToString(", ") { it.name }}"
                }
        }
        .subscribe(
            { groupInfo ->
                Log.d(TAG, groupInfo)
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun mergeOperator(){
    val observable = Observable.merge(
        getUser(),
        getUserDetails()
    )

    observable
        .subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { all ->
                Log.d(TAG, all.toString())
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun concatOperator(){
    val observable = Observable.concat(
        getUser(),
        getUserDetails()
    )

    observable
        .subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { all ->
                Log.d(TAG, all.toString())
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )
}

fun startWithOperator() {
    val defaultUser = User(0, "Default User", "default@example.com", 0)

    val observable = Observable.fromIterable(userList).startWith(Observable.just(defaultUser))
        observable.subscribeOn(schedulers)
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

fun zipOperator() {

    val userObservable = Observable.fromIterable(userList)
    val userDetailsObservable = Observable.fromIterable(userDetailsList)

    Observable.zip(
        userObservable,
        userDetailsObservable,
        { user, userDetails ->
            listOf(user, userDetails)
        }
    ).subscribeOn(schedulers)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { combined ->
                Log.d(TAG, "Combined: $combined")
            },
            { error ->
                Log.d(TAG, "Error: ${error.message}")
            },
            {
                Log.d(TAG, "Completed")
            }
        )

}

fun getUser():Observable<User>{
    return Observable.fromIterable(userList)
}

fun getUserDetails():Observable<UserDetails>{
    return Observable.fromIterable(userDetailsList)
}

fun fetchUser(id:Int):Observable<User>{
    return Observable.fromIterable(userList)
        .filter { it.id == id }
}

fun getLocationsData(){
    val latitute = 230.022
    val longitude = 220.011
    Log.d(TAG,"Latitute : $latitute Longitude : $longitude")
}
