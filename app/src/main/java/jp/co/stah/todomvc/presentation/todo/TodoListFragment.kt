package jp.co.stah.todomvc.presentation.todo

//import androidx.core.view.size
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import jp.co.stah.todomvc.presentation.BaseFragment
import timber.log.Timber


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

            Timber.i("id ? $i ")
            val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)
            val done = check.visibility == View.VISIBLE
            val textView = view.findViewById<TextView>(jp.co.stah.todomvc.R.id.textView)

            mPresenter.check(i, !done, textView.text.toString())
            //if(view.id == R.id.textView){
            /*
            val textView = view.findViewById<TextView>(jp.co.stah.todomvc.R.id.textView)
            val paint = textView.paint

            val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)
            if (check.visibility == View.VISIBLE) {
                check.visibility = View.GONE
                textView.setTextColor(Color.BLACK)
                paint.flags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            } else {
                check.visibility = View.VISIBLE
                textView.setTextColor(Color.LTGRAY)
                paint.flags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                paint.isAntiAlias = true
            }
            */
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