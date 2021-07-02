package ipsoft.lembretesetarefas.ui.newtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ipsoft.lembretesetarefas.datasource.model.Task
import ipsoft.lembretesetarefas.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewTaskViewModel(private val repository: TaskRepository) : ViewModel() {

    fun addTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertAll(task)
    }

    fun getTaskById(id: Int) = runBlocking {
        val asyncResult = async {
            repository.loadById(id)
        }

        return@runBlocking asyncResult.await()
    }

    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(task)
    }


}