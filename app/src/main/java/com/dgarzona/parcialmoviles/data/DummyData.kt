package com.dgarzona.parcialmoviles.data

import com.dgarzona.parcialmoviles.models.Actress

val actress1 = Actress(name = "Selena Gomez", age = 22)
val actress2 = Actress(name = "Margot Robbie", age = 30)
val actress3 = Actress(name = "Gal Gabot", age = 32)


val actresses: MutableList<Actress> = mutableListOf(actress1, actress2, actress3)