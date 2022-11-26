package com.rngabomu.android.lab03.model

import androidx.lifecycle.ViewModel

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
}