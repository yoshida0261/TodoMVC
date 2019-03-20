package jp.co.stah.todomvc.presentation.presentor.todo

import jp.co.stah.todomvc.presentation.BasePresenter
import timber.log.Timber

class TodoListPresenter : BasePresenter<TodoListContract.View>(), TodoListContract.Interaction {

    val list = ArrayList<TodoListItem>()
    var id = 0

    override fun add(todo: String) {
        list.add(TodoListItem(id, false, todo))
        mView.showChangeItem(list)
        id++
    }

    override fun edit(listNo: Int, todo: String) {

        if (todo.isEmpty()) {
            delete(listNo)
            return
        }
    }

    override fun check(listNo: Int, check: Boolean, todo: String) {

        val item = list[listNo]
        item.done = check
        mView.showChangeItem(list)
    }

    override fun delete(listNo: Int) {
        list.removeAt(listNo)
        mView.showChangeItem(list)
    }

    override fun showAll() {
        mView.showChangeItem(list)
    }


    override fun showActive() {

        val activeList = ArrayList<TodoListItem>()

        list.forEach {
            if (!it.done) {
                activeList.add(it)
            }
        }
        mView.showChangeItem(activeList)
    }


    override fun showCompleted() {
        val activeList = ArrayList<TodoListItem>()
        list.forEach {
            if (it.done) {
                activeList.add(it)
            }
        }
        mView.showChangeItem(activeList)

    }

}