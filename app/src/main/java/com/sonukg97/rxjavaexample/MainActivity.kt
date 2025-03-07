package com.sonukg97.rxjavaexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonukg97.rxjavaexample.ui.theme.RxJavaExampleTheme
import io.reactivex.rxjava3.disposables.CompositeDisposable

val compositeDisposable = CompositeDisposable()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RxJavaExampleTheme {
            //justOperator()
               // justOperatorUsingList()
                //fromArrayOperator()
                //fromIterableOperator()
                //rangeOperator()
                //repeatOperator()
                //intervalOperator()
                //timerOperator()
                //createOperator()
                //filterOperator()
                //lastOperator()
                //distinctOperator()
                //skipOperator()
                //bufferOperator()
                //mapOperator()
                //flatMapOperator()
                //groupByOperator()
                //mergeOperator()
                //concatOperator()
                //startWithOperator()
                //zipOperator()
                //createObservable()
                //createSingleObservable()
                //createMaybeObservable()
                //createCompletableObservable()
                //createFlowableObservable()
                //flowableBufferBackpressure()
                //flowableDropBackpressure()
                //flowableLatestBackpressure()
                //flowableErrorBackpressure()
                //flowableMissingBackpressure()
                //createDisposableObservable()
                //ioAndMainScheduler()
                //computationScheduler()
                //newThreadScheduler()
                //trumpoLineScheduler()
                //fromLooperScheduler()
                //coldObservable()
                //hotObservable()
                //asyncSubject()
                //asyncSubjectTwo()
                //asyncSubjectThree()
                //behaviorSubject()
                //behaviorSubjectTwo()
                //behaviorSubjectThree()
                //publishSubject()
                //publishSubjectTwo()
                //publishSubjectThree()
                //replaySubject()
                //replaySubjectTwo()
            }
        }
    }


    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        Log.d(TAG,"onDestroy")
        super.onDestroy()
    }
}

