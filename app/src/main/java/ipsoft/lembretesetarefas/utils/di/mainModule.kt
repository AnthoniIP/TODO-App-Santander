package ipsoft.lembretesetarefas.utils.di

import ipsoft.lembretesetarefas.repository.TaskRepository
import ipsoft.lembretesetarefas.repository.TaskRepositoryImpl
import ipsoft.lembretesetarefas.ui.main.MainViewModel
import ipsoft.lembretesetarefas.ui.newtask.NewTaskViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val androidModule = module {

    single<TaskRepository> { TaskRepositoryImpl(androidApplication()) }
    viewModel { MainViewModel(repository = get()) }
    viewModel { NewTaskViewModel(repository = get()) }
}