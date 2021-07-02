package ipsoft.lembretesetarefas.repository

import android.content.Context
import ipsoft.lembretesetarefas.datasource.model.Task
import ipsoft.lembretesetarefas.datasource.room.AppDatabase

class TaskRepositoryImpl(context: Context) : TaskRepository {

    private val db = AppDatabase.createDataBase(context = context)

    override suspend fun getAll(): List<Task> = db.getAll()

    override suspend fun insertAll(task: Task) = db.insertAll(task)

    override suspend fun loadById(id: Int) = db.loadById(id)
    override suspend fun update(task: Task) = db.update(task)
}