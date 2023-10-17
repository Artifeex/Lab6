package com.example.lab6.fifth.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab6.second.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()

        private const val DB_NAME = "db_items.db"

        fun getInstance(context: Context): AppDataBase {
            INSTANCE?.let { return it }
            synchronized(LOCK) {
                INSTANCE?.let { return it }
                val db =
                    Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        DB_NAME
                    ).build()
                INSTANCE = db
                return db
            }

        }

    }
}