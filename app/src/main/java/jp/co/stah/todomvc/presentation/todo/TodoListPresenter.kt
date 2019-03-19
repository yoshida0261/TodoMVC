package jp.co.stah.todomvc.presentation.todo

import jp.co.stah.todomvc.domain.usecase.TodoImpl
import jp.co.stah.todomvc.presentation.BasePresenter

class TodoListPresenter : BasePresenter<TodoListContract.View>(), TodoListContract.Interaction {

    val todoimpl = TodoImpl()
    val list = ArrayList<TodoListItem>()

    override fun onViewCreated() {
        super.onViewCreated()
    }

    override fun add(item: String) {
        todoimpl.add(item)
        list.add(TodoListItem(false, item))
        mView.showChangeItem(list)
    }

    override fun edit(listNo: Int, item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun check(listNo: Int, check: Boolean, item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dlete(listNo: Int, item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}