package com.sonukg97.rxjavaexample

import android.os.Bundle
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
                groupByOperator()
            }
        }
    }


    companion object{
        private const val TAG = "MainActivity"
    }
}

