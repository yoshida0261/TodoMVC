package jp.co.stah.todomvc.domain.usecase

interface Todo {

    fun add(todo: String)
    fun edit(id:Int, todo:String)
    fun check(id: Int, done:Boolean)
    fun delete(id:Int)
}