package ipsoft.lembretesetarefas.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ipsoft.lembretesetarefas.R
import ipsoft.lembretesetarefas.databinding.FragmentMainBinding
import ipsoft.lembretesetarefas.ui.main.adapter.TasksAdapter
import ipsoft.lembretesetarefas.utils.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.changeColor(R.color.black)

    }

    private fun setListeners() {
        binding.fabAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newTaskFragment)
        }
    }

    private fun setRecycler() {
        binding.rcvTasks.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
            adapter = TasksAdapter(mainViewModel.getTasks())
        }
    }


}