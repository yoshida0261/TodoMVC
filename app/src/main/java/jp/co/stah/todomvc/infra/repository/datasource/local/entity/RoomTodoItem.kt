package jp.co.stah.todomvc.infra.repository.datasource.local.entity

//@Entity(tableName = "todo")
data class RoomTodoItem(val id: Int, val check: Boolean, val todo: String)