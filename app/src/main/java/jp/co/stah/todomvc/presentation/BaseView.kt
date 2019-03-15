
package jp.co.stah.todomvc.presentation

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity


interface BaseView {
    fun startActivity(intent: Intent)

    fun startActivityForResult(intent: Intent, requestCode: Int)

    fun finishActivity()

    fun getContext(): Context

    fun getActivity(): FragmentActivity?
}