package jp.co.stah.todomvc.presentation.todo

//import androidx.core.view.size
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import jp.co.stah.todomvc.R
import jp.co.stah.todomvc.presentation.BaseFragment


class TodoListFragment : BaseFragment<TodoListContract.View, TodoListPresenter>(), TodoListContract.View {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.findViewById<Button>(jp.co.stah.todomvc.R.id.addButton).setOnClickListener {
            if (activity!!.findViewById<EditText>(jp.co.stah.todomvc.R.id.editText).text.isNotEmpty()) {
                mPresenter.add(activity!!.findViewById<EditText>(jp.co.stah.todomvc.R.id.editText).text.toString())
            }
        }
        val listView = activity!!.findViewById<ListView>(jp.co.stah.todomvc.R.id.todo_list)
        listView.setOnItemClickListener { adapterView, view, i, l ->

            //if(view.id == R.id.textView){


                val textView = view.findViewById<TextView>(R.id.textView)
                textView.setTextColor(Color.LTGRAY)
                val paint = textView.paint
                paint.flags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                paint.isAntiAlias = true

            //}

        }

    }

    override fun showChangeItem(list: ArrayList<TodoListItem>) {
        val listView = activity!!.findViewById<ListView>(jp.co.stah.todomvc.R.id.todo_list)
        val adapter = TodoListAdapter(activity!!, R.layout.todo_list_item, list)
        listView.adapter = adapter
    }

    override fun getViewContract(): TodoListContract.View {
        return this
    }

    override fun getPresenter(): TodoListPresenter {


        return TodoListPresenter()
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getContext(): Context {
        return activity!!
    }


}