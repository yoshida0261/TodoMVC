package jp.co.stah.todomvc.presentation

import android.os.Bundle
import jp.co.stah.todomvc.R
import jp.co.stah.todomvc.presentation.todo.TodoListFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)
        replaceFragment(TodoListFragment(), R.id.container)
    }
}
