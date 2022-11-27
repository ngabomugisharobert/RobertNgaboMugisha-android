package com.rngabomu.android.lab03.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    var taskList = mutableListOf<Task>()

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
    }

//    fun update(task: Task   ) = viewModelScope.launch {
//        taskList.remove(task)
//        task.isCompleted = !task.isCompleted
//        taskList.add(task)
//        Log.d("TaskViewModel", "update: $taskList")
//    }
}