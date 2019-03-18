package jp.co.stah.todomvc.infra.repository.datasource.local.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "todo")
data class RoomTodoItem(val id: Int, val check: Boolean, val todo: String)