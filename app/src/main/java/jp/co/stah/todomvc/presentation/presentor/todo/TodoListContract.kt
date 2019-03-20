package jp.co.stah.todomvc.presentation.presentor.todo

import jp.co.stah.todomvc.presentation.BaseView

interface TodoListContract {
    interface View : BaseView {

        fun showChangeItem(list : ArrayList<TodoListItem>)

    }

    interface Interaction {
        fun add(todo: String)
        fun edit(listNo: Int, todo: String)
        fun check(listNo: Int, check: Boolean, todo: String)
        fun delete(listNo: Int)
        fun showAll()
        fun showActive()
        fun showCompleted()


    }
}