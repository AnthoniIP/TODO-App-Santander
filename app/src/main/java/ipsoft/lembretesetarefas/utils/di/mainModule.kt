package ipsoft.lembretesetarefas.utils.di

import ipsoft.lembretesetarefas.ui.main.MainViewModel
import ipsoft.lembretesetarefas.ui.newtask.NewTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val androidModule = module {
    viewModel { MainViewModel() }
    viewModel { NewTaskViewModel() }
}