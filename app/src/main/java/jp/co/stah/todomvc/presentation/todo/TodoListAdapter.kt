package jp.co.stah.todomvc.presentation.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


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
        textView.text = item.todo
        val check = view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_check)

        view.findViewById<ImageView>(jp.co.stah.todomvc.R.id.image_circle).setOnClickListener {

            if (check.visibility == View.VISIBLE) {
                check.visibility = View.GONE
            } else {
                check.visibility = View.VISIBLE

            }

        }

        /*
        if (check.visibility == View.GONE) {

            textView.setTextColor(Color.LTGRAY)
            val paint = textView.paint
            paint.flags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            paint.isAntiAlias = true

        }*/


        return view
    }
}