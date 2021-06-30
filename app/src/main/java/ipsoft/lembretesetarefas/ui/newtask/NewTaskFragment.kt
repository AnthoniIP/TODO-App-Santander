package ipsoft.lembretesetarefas.ui.newtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ipsoft.lembretesetarefas.databinding.FragmentNewTaskBinding
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import ipsoft.lembretesetarefas.utils.extensions.format
import ipsoft.lembretesetarefas.utils.extensions.text
import java.util.*


class NewTaskFragment : Fragment() {

    private var _binding: FragmentNewTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setScreen()
        setListeners()
    }


    private fun setScreen() {

        binding.toolbarBackButton.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setListeners() {

        binding.edtTitle.setOnClickListener {

        }
        binding.edtDesc.setOnClickListener {

        }
        binding.tilDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            val timeZone = TimeZone.getDefault()
            val offset = timeZone.getOffset(Date().time) * -1
            datePicker.addOnPositiveButtonClickListener {
                binding.tilDate.text = Date(it + offset).format()

            }
            activity?.supportFragmentManager?.let { supportFragmentManager ->
                datePicker.show(
                    supportFragmentManager,
                    "DATE_PICKER_TAG"
                )

            }
        }
        binding.edtTime.setOnClickListener {

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}