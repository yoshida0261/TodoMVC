package jp.co.stah.todomvc.presentation.presentor.todo

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import jp.co.stah.todomvc.R
import timber.log.Timber


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
        val editText = view.findViewById<EditText>(R.id.todoText)
        val paint = editText.paint


        Timber.i("editText ${editText.text} item ${item.todo}")
        if (editText.text.isEmpty()) {
            editText.setText(item.todo, TextView.BufferType.NORMAL)
        }

        editText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val edit = v as EditText
                item.todo = edit.text.toString()

            }
        }

        editText.setOnClickListener {
            val list = parent as ListView
            list.performItemClick(view, position, R.id.todoText.toLong())
        }

        view.findViewById<FrameLayout>(R.id.checkFrameLayout).setOnClickListener {
            val list = parent as ListView
            list.performItemClick(view, position, R.id.checkFrameLayout.toLong())
        }


        val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)

        val delete = view.findViewById<ImageView>(R.id.delete_button)
        delete.setOnClickListener {
            Timber.i("click delete_button")
            val list = parent as ListView
            list.performItemClick(view, position, R.id.delete_button.toLong())
        }

        if (!item.done) {
            check.visibility = View.GONE
            editText.setTextColor(Color.BLACK)
            paint.flags = editText.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        } else {
            check.visibility = View.VISIBLE
            editText.setTextColor(Color.LTGRAY)
            paint.flags = editText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            paint.isAntiAlias = true
        }

        return view
    }
}