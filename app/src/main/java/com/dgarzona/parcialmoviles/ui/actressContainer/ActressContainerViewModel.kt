package com.dgarzona.parcialmoviles.ui.actressContainer

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dgarzona.parcialmoviles.ActressApplication
import com.dgarzona.parcialmoviles.models.Actress
import com.dgarzona.parcialmoviles.repositories.ActressRepository

class ActressContainerViewModel(private  val actressRepository: ActressRepository) : ViewModel() {

    private val actresses : MutableList<Actress> = actressRepository.getActresses()

    fun getActresses() = actresses

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val repo = (this[APPLICATION_KEY] as ActressApplication).actressRepository
                ActressContainerViewModel(repo)
            }
        }
    }
}