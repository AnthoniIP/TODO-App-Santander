package ipsoft.lembretesetarefas.ui.main

import androidx.lifecycle.ViewModel
import ipsoft.lembretesetarefas.repository.TaskRepository
import kotlinx.coroutines.*

class MainViewModel(private val repository: TaskRepository) : ViewModel() {


    fun getTasks() = runBlocking {
        val asyncResult = async {
            repository.getAll()
        }

        return@runBlocking asyncResult.await()
    }

}

