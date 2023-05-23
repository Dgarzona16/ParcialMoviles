package com.dgarzona.parcialmoviles.ui.newActress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dgarzona.parcialmoviles.ActressApplication
import com.dgarzona.parcialmoviles.models.Actress
import com.dgarzona.parcialmoviles.repositories.ActressRepository

class NewActressViewModel(private val actressRepository: ActressRepository) : ViewModel() {

    fun addActress(actress: Actress) = actressRepository.save(actress)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val repo = (this[APPLICATION_KEY] as ActressApplication).actressRepository
                NewActressViewModel(repo)
            }
        }
    }
}