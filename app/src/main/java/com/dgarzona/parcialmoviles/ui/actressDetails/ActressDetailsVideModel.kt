package com.dgarzona.parcialmoviles.ui.actressDetails

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dgarzona.parcialmoviles.ActressApplication
import com.dgarzona.parcialmoviles.repositories.ActressRepository

class ActressDetailsVideModel(private val actressRepository: ActressRepository): ViewModel() {
    fun getActress(actressName : String) = actressRepository.findByName(actressName)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val repo = (this[APPLICATION_KEY] as ActressApplication).actressRepository
                ActressDetailsVideModel(repo)
            }
        }
    }
}