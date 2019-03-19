package jp.co.stah.todomvc.domain.usecase

import jp.co.stah.todomvc.domain.model.TodoAction

class TodoImpl : Todo {

    private val list : MutableList<TodoAction> = mutableListOf()
    private var id = 0

    override fun add(todo: String) {

        val item = TodoAction(id,false, todo)
        list.add(item)
        id += 1
    }

    override fun edit(id: Int, todo: String) {

        var count = 0
        list.forEach {
            if(it.id == id ){
               /*
                list.removeAt(count)
                val item = TodoAction(id, it.done, todo)
                list.add(item)*/
                it.itemName = todo
                return

            }
            count++
        }

    }

    override fun check(id: Int, done: Boolean) {
        var count = 0
        list.forEach {
            if(it.id == id ){
                //list.removeAt(count)
                //val item = TodoAction(id, done, it.itemName)
                //list.add(item)
                it.done = done
                return
            }
            count++
        }

    }

    override fun delete(id: Int) {
        var count = 0
        list.forEach {
            if(it.id == id ){
                list.removeAt(count)
                return
            }
            count++
        }


    }
}