package jp.co.stah.todomvc.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import jp.co.stah.todomvc.R
import jp.co.stah.todomvc.presentation.todo.TodoListAdapter
import jp.co.stah.todomvc.presentation.todo.TodoListItem

class MainActivity : AppCompatActivity() {

    val items = ArrayList<TodoListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<ListView>(R.id.todo_list)
        val data = TodoListItem(false, "テスト")
        items.add(data)
        val adapter = TodoListAdapter(this, R.layout.todo_list_item, items)
        list.adapter = adapter

    }
}
