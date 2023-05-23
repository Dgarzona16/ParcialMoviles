package com.dgarzona.parcialmoviles

import android.app.Application
import com.dgarzona.parcialmoviles.data.actresses
import com.dgarzona.parcialmoviles.repositories.ActressRepository

class ActressApplication: Application() {
    val actressRepository: ActressRepository by lazy {
        ActressRepository(actresses)
    }
}