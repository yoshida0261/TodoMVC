package jp.co.stah.todomvc.presentation

import android.os.Bundle
import jp.co.stah.todomvc.R
import jp.co.stah.todomvc.presentation.todo.TodoListFragment
import jp.co.stah.todomvc.presentation.todo.TodoListItem

class MainActivity : BaseActivity() {

    val items = ArrayList<TodoListItem>()

    /*
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_all -> {
                //message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_active -> {
                //message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_check -> {
                //message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container)

       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        replaceFragment(TodoListFragment(), R.id.container)
        /*
        val list = findViewById<ListView>(R.id.todo_list)
        val data = TodoListItem(false, "テスト")
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)
        items.add(data)

        val adapter = TodoListAdapter(this, R.layout.todo_list_item, items)
        list.adapter = adapter
        */

    }


}
