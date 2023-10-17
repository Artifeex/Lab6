package com.example.lab6.fifth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab6.fifth.database.AppDataBase
import com.example.lab6.second.Task
import kotlinx.coroutines.launch

class FifthTaskViewModel(
    application: Application
): AndroidViewModel(application) {

    private val database = AppDataBase.getInstance(application)

    fun getTasks() = database.getDao().getTasks()

    fun addTask(text: String) {
        viewModelScope.launch {
            database.getDao().addTask(Task(description = text))
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            database.getDao().deleteTask(task)
        }
    }


}