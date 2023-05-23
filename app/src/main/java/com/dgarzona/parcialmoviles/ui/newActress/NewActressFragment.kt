package com.dgarzona.parcialmoviles.ui.newActress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dgarzona.parcialmoviles.R
import com.dgarzona.parcialmoviles.databinding.FragmentNewActressBinding
import com.dgarzona.parcialmoviles.models.Actress

class NewActressFragment : Fragment() {
    private val viewmodel: NewActressViewModel by viewModels{
        NewActressViewModel.Factory
    }
    private lateinit var  binding: FragmentNewActressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_new_actress,
                container,
                false
        )
        listener()
        return binding.root
    }
    private fun listener(){
        binding.apply {
            submit.setOnClickListener{
                val actress = Actress(
                    name = actressName.text.toString(),
                    age = actressAge.text.toString().toInt(),
                )
                viewmodel.addActress(actress)

                findNavController().navigate(R.id.action_newActressFragment_to_actressContainerFragment)
            }
        }
    }
}