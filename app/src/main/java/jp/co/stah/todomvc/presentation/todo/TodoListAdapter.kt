package jp.co.stah.todomvc.presentation.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import jp.co.stah.todomvc.R

class TodoListAdapter(context: Context, resource: Int, list: List<TodoListItem>) :
    ArrayAdapter<TodoListItem>(context, resource, list) {

    private val mResource = resource
    private val mContext = context
    private val mList = list
    private var mInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = mInflater.inflate(mResource, null)
        } else {
            view = convertView
        }

        val item = mList[position]
        view.findViewById<TextView>(R.id.textView).text = item.todoItem

        return view
    }
}