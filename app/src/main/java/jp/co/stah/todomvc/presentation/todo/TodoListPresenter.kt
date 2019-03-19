package jp.co.stah.todomvc.presentation.todo

import jp.co.stah.todomvc.presentation.BasePresenter

class TodoListPresenter : BasePresenter<TodoListContract.View>(), TodoListContract.Interaction {

    val list = ArrayList<TodoListItem>()
    var id = 0

    override fun onViewCreated() {
        super.onViewCreated()
    }

    override fun add(item: String) {
        list.add(TodoListItem(id, false, item))
        mView.showChangeItem(list)
        id++
    }

    override fun edit(listNo: Int, item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun check(listNo: Int, check: Boolean, item: String) {

        val item = list[listNo]
        item.done = check
        mView.showChangeItem(list)


    }

    override fun dlete(listNo: Int, item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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