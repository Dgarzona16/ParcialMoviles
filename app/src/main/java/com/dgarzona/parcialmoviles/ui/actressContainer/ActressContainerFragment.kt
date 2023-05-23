package com.dgarzona.parcialmoviles.ui.actressContainer

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dgarzona.parcialmoviles.ActressApplication
import com.dgarzona.parcialmoviles.R
import com.dgarzona.parcialmoviles.databinding.FragmentActressContainerBinding

class ActressContainerFragment : Fragment() {

    private val viewmodel: ActressContainerViewModel by viewModels{
        ActressContainerViewModel.Factory
    }

    private lateinit var binding: FragmentActressContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_actress_container,
                container,
                false
        )
        setupRecyclerView()
        listener()
        return binding.root
    }

    private fun setupRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(ActressApplication())

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.recyclerview_spacing)
        val itemDecoration = object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(spacingInPixels, spacingInPixels, spacingInPixels, spacingInPixels)
            }
        }
        val adapter = ActressContainerAdapter(viewmodel.getActresses())
        binding.actressList.apply {
            this.adapter = adapter
            this.layoutManager = layoutManager
            this.addItemDecoration(itemDecoration)
        }
    }

    private fun listener(){
        binding.apply {
            addActress.setOnClickListener {
                findNavController().navigate(R.id.action_actressContainerFragment_to_newActressFragment)
            }
            //when touch item to recyclerview navigate to details
            actressList.children.forEach {
                it.setOnClickListener {
                    findNavController().navigate(R.id.action_actressContainerFragment_to_actressDetailsFragment)
                }
            }
        }
    }
}