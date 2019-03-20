package jp.co.stah.todomvc.presentation.presentor.todo

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.*
import jp.co.stah.todomvc.R
import jp.co.stah.todomvc.presentation.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class TodoListFragment : BaseFragment<TodoListContract.View, TodoListPresenter>(), TodoListContract.View {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_all -> {
                mPresenter.showAll()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_active -> {
                mPresenter.showActive()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_check -> {
                mPresenter.showCompleted()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        activity!!.findViewById<Button>(jp.co.stah.todomvc.R.id.addButton).setOnClickListener {
            val textView = activity!!.findViewById<EditText>(jp.co.stah.todomvc.R.id.editText)
            if (textView.text.isNotEmpty()) {
                mPresenter.add(activity!!.findViewById<EditText>(jp.co.stah.todomvc.R.id.editText).text.toString())
                textView.text.clear()
            }
        }
        val listView = activity!!.findViewById<ListView>(jp.co.stah.todomvc.R.id.todo_list)
        listView.setOnItemClickListener { _, view, i, id ->

            val editText = view.findViewById<EditText>(jp.co.stah.todomvc.R.id.todoText)
            if (id == R.id.delete_button.toLong()) {
                mPresenter.delete(i)
            }
            if (id == R.id.checkFrameLayout.toLong()) {

                Timber.i("id ? $i ")
                val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)
                val done = check.visibility == View.VISIBLE


                mPresenter.check(i, !done, editText.text.toString())
            }

            if(id == R.id.todoText.toLong()){
                mPresenter.edit(i, editText.text.toString())
            }
        }

    }

    override fun showChangeItem(list: ArrayList<TodoListItem>) {
        val listView = activity!!.findViewById<ListView>(jp.co.stah.todomvc.R.id.todo_list)
        val adapter = TodoListAdapter(activity!!, jp.co.stah.todomvc.R.layout.todo_list_item, list)
        listView.adapter = adapter
    }

    override fun getViewContract(): TodoListContract.View {
        return this
    }

    override fun getPresenter(): TodoListPresenter {


        return TodoListPresenter()
    }

    override fun getLayoutRes(): Int {
        return jp.co.stah.todomvc.R.layout.activity_main
    }

    override fun getContext(): Context {
        return activity!!
    }


}