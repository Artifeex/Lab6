package com.example.lab6.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondTaskViewModel: ViewModel() {

    var lastId = 1

    private val lists: MutableLiveData<List<Task>> = MutableLiveData<List<Task>>(listOf())
    val listsLD: LiveData<List<Task>>
        get() = lists

    fun addNewListItem() {
        val newItem = Task(lastId++)
        val newList = lists.value!!.toMutableList()
        newList.add(newItem)
        lists.value = newList
    }

    fun deleteListItem(itemId: Int) {
        val newList = lists.value!!.toMutableList()
        for(index in newList.indices) {
            if(newList[index].id == itemId) {
                newList.removeAt(index)
                break
            }
        }
        lists.value = newList
    }

}