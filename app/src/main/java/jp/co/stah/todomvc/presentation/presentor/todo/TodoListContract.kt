package jp.co.stah.todomvc.presentation.presentor.todo

import jp.co.stah.todomvc.presentation.BaseView

interface TodoListContract {
    interface View : BaseView {

        fun showChangeItem(list : ArrayList<TodoListItem>)

    }

    interface Interaction {
        fun add(item: String)
        fun edit(listNo: Int, item: String)
        fun check(listNo: Int, check: Boolean, item: String)
        fun delete(listNo: Int)
        fun showAll()
        fun showActive()
        fun showCompleted()


    }
}