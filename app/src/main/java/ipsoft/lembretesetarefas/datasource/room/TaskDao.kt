package ipsoft.lembretesetarefas.datasource.room

import androidx.room.*
import ipsoft.lembretesetarefas.datasource.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE id IN (:taskId)")
    fun loadById(taskId: Int): Task


    @Insert
    fun insertAll(user: Task)

    @Delete
    fun delete(user: Task)

    @Update
    fun update(user: Task)
}
