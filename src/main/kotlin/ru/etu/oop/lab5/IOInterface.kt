package ru.etu.oop.lab5

import java.io.File
import com.google.gson.*
import ru.etu.oop.lab2.*

class IOInterface<T>{
    private val gsonBuilder = GsonBuilder()
    private val gson: Gson

    // Initializes GSON
    init {
        gsonBuilder.registerTypeAdapter(Shape::class.java, InterfaceAdapter<Shape>())
        gson = gsonBuilder.create()
    }

    // Reads the list from *.json file
    fun read (path: String): MutableList<T> {
        val json = File(path).readText()
        return gson.fromJson<MutableList<T>>(json, Shape::class.java)
    }

    // Writes JSON Array into *.json file
    fun write(list: MutableList<T>, path: String) {
       File(path).writeText(gson.toJson(list, Shape::class.java))
    }

}


