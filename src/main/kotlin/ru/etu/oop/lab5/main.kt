package ru.etu.oop.lab5

import ru.etu.oop.lab2.*

fun main() {
    val shapesList = mutableListOf(
            Circle(3f),
            Rectangle(5f, 10f),
            Square(3f),
            Triangle(15f, 10f, 10f)
    )

    // IO stream for Shapes list
    val shapeIO = IOInterface<Shape>()
    shapeIO.write(shapesList, "src/main/kotlin/ru/etu/oop/lab5/shapes.json")
    val restoredShapes = shapeIO.read("src/main/kotlin/ru/etu/oop/lab5/shapes.json")

    println("Restored shapes: $restoredShapes")
}