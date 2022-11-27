package com.rngabomu.android.lab03.ui.compose
import android.content.Context
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rngabomu.android.lab03.model.TaskViewModel
import com.rngabomu.android.lab03.R
import com.rngabomu.android.lab03.model.Task
import com.rngabomu.android.lab03.model.tasksData
import com.rngabomu.android.lab03.ui.theme.Lab03Theme
import java.util.*

@Composable
fun TaskScreen() {

//    task view model
val viewModel: TaskViewModel = viewModel()

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    val taskListstate by remember { mutableStateOf(viewModel.taskList) }

Scaffold(

    backgroundColor = MaterialTheme.colors.surface,
    floatingActionButton = {
        FloatingActionButton(
            onClick = {showDialog = true}
        )
        {
            Icon(Icons.Filled.Add, contentDescription = "")
        }
    },
    content = {
        if (showDialog){
            AddTaskDialog(context, dismissDialog = {showDialog = false}, {viewModel.add(it)})
        }
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 8.dp
            )
        )
        {
            items(taskListstate, key={task -> task.taskId}) { task ->
                TaskItem(
                    item = task,
                    context,
                    {viewModel.delete(it)},
                    {viewModel.update(task)})
            }
        }
    }
)
}


@Composable
fun AddTaskDialog(context: Context, dismissDialog:() -> Unit, addTask: (Task) -> Unit){
    var taskTextField by remember {
        mutableStateOf("")
    }


    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.addTask), style = MaterialTheme.typography.h6) },
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = { Text(text= stringResource(id = R.string.taskName)) }, value = taskTextField, onValueChange = {taskTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        confirmButton = {
            Button(onClick = {
                if(taskTextField.isNotEmpty()) {
                    val newID = UUID.randomUUID().toString();
                    addTask(Task(newID, taskTextField, true))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.TaskCreated),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskItem(
    item: Task,
    context: Context,
    deleteTask: (Task) -> Unit,
    onCheckedChange: (Boolean) -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    Log.e("TaskItem", "TaskItem: $item")
    var checkedState by remember { mutableStateOf(item.isCompleted) }

    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.primaryVariant),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            " " + item.title,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = item.title, style = MaterialTheme.typography.h6)
            Checkbox(checked = checkedState, onCheckedChange = onCheckedChange)
        }

    }
    if (showDeleteDialog){
        deleteTaskDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteTask)
    }
}




@Composable
fun deleteTaskDialog(context: Context, dismissDialog:() -> Unit, item: Task, deleteTask: (Task) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = "delete", style = MaterialTheme.typography.h6)},
        confirmButton = {
            Button(onClick = {
                deleteTask(item)
                Toast.makeText(
                    context,
                    "deleted",
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = "yes")
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = "No")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab03Theme {
        TaskScreen()
    }
}