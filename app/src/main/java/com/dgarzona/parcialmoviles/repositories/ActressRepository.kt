package com.dgarzona.parcialmoviles.repositories

import com.dgarzona.parcialmoviles.models.Actress

class ActressRepository(private val actresses : MutableList<Actress>) {

    fun getActresses() = actresses

    fun save(actress: Actress) = actresses.add(actress)

    fun findByName(name : String){
        val actress = actresses.map {
            it.name = name
        }
    }
}