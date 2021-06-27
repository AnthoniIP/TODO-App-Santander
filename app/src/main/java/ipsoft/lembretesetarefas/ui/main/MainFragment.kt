package ipsoft.lembretesetarefas.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ipsoft.lembretesetarefas.R
import ipsoft.lembretesetarefas.databinding.FragmentMainBinding
import ipsoft.lembretesetarefas.utils.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    val myViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.changeColor(R.color.black)

        binding.btnNewTaskFragment.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newTaskFragment)
        }

    }


}