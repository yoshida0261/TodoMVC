package jp.co.stah.todomvc.presentation

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    fun replaceFragment(fragment: Fragment, @IdRes containerId: Int) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(containerId, fragment, fragment.javaClass.simpleName)
        ft.commit()
    }
}