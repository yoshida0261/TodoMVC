package jp.co.stah.todomvc.infra.repository.datasource.local.dao

import jp.co.stah.todomvc.infra.repository.datasource.local.entity.RoomTodoItem

//@Dao
interface TodoDao {

  //  @Query("SELECT * FROM todo")
    fun getAll(): List<RoomTodoItem>

    //@Insert
    fun insert(todo: RoomTodoItem)

//    @Delete
    fun delete(todo: RoomTodoItem)
}