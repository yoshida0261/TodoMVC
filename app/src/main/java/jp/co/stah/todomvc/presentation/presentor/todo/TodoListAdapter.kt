package jp.co.stah.todomvc.presentation.presentor.todo

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
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
        val textView = view.findViewById<TextView>(jp.co.stah.todomvc.R.id.textView)
        val paint = textView.paint
        textView.text = item.todo
        val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)

        val delete = view.findViewById<ImageView>(R.id.delete_button)
        delete.setOnClickListener {
            Timber.i("click delete_button")
            val list = parent as ListView
            list.performItemClick(view, position, R.id.delete_button.toLong())
        }

        if (!item.done) {
            check.visibility = View.GONE
            textView.setTextColor(Color.BLACK)
            paint.flags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        } else {
            check.visibility = View.VISIBLE
            textView.setTextColor(Color.LTGRAY)
            paint.flags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            paint.isAntiAlias = true
        }

        return view
    }
}