package ru.etu.oop.lab6

import ru.etu.oop.lab2.*
import tornadofx.*
import javafx.collections.FXCollections
import javafx.stage.FileChooser
import ru.etu.oop.lab5.IOInterface
import java.util.*

class MainController : Controller() {
    var shapesList = FXCollections.observableArrayList<Shape>()

    fun add(value: Shape) {
        shapesList.add(value)
    }

    fun moveUp(i: Int) {
        if (i == 0) {
            return
        }
        Collections.swap(shapesList, i, i - 1)
    }

    fun moveDown(i: Int) {
        if (i == shapesList.size - 1) {
            return
        }
        Collections.swap(shapesList, i, i + 1)
    }

    fun save() {
        try {
            val shapeIO = IOInterface<Shape>()
            val filter = arrayOf(FileChooser.ExtensionFilter("JSON file", "*.json"))
            val filepath = chooseFile("Save shapes into file", filter, mode = FileChooserMode.Save)[0].absolutePath.toString()
            if (filepath.isNotEmpty()) {
                shapeIO.write(shapesList, filepath)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun open() {
        try {
            val filter = arrayOf(FileChooser.ExtensionFilter("JSON file", "*.json"))
            val filepath = chooseFile("Choose a JSON file", filter)[0].absolutePath.toString()
            if (filepath.isNotEmpty()) {
                val shapeIO = IOInterface<Shape>()
                val restoredShapes = shapeIO.read(filepath)
                shapesList.clear()
                shapesList.addAll(restoredShapes)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}