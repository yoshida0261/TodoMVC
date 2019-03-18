package jp.co.stah.todomvc.infra.repository.datasource.local.db

import androidx.room.RoomDatabase
import jp.co.stah.todomvc.infra.repository.datasource.local.dao.TodoDao


abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

}