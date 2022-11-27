package com.rngabomu.android.lab03.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {

   private var _state : MutableLiveData<List<Task>> = MutableLiveData()
    val state :LiveData<List<Task>> get() = _state



    var taskList = mutableListOf<Task>()
//    var taskList = mutableListOf<Task>()

    fun add(newTask: Task){
        taskList.add(newTask)
    }

    fun delete(task: Task){
        taskList.remove(task)
    }

    fun update(task: Task){
        taskList.remove(task)
        task.isCompleted = !task.isCompleted
        taskList.add(task)
        Log.e("TaskViewModel", "update: $task")
    }

}

data class TaskState( val taskList: List<Task> = emptyList())