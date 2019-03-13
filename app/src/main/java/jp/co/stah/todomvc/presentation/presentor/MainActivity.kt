package jp.co.stah.todomvc.presentation.presentor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.co.stah.todomvc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
