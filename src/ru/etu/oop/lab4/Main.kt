package ru.etu.oop.lab4
import ru.etu.oop.lab2.*

fun main() {
    val rectWidth = 5.0F
    val rectHeight = 3.0F
    val rectangle = Rectangle(rectWidth, rectHeight)

    val squareSize = 3.0F
    val square = Square(squareSize)

    val trSize1 = 4.0F
    val trSize2 = 3.0F
    val trSize3 = 5.0F
    val triangle = Triangle(trSize1, trSize2, trSize3)

    val circleR = 4.0F
    val circle = Circle(circleR)

    val square2Size = 5.0F
    val square2 = Square(square2Size)

    val shapesList = mutableListOf(rectangle, square, triangle, circle)

    val accum = ShapeAccumulator()

    accum.addAll(shapesList)
    println("Sum area: ${accum.getTotalArea()}")
    println("Sum perimeter: ${accum.getTotalPerimeter()}")

    accum.add(square2)
    println("Sum area: ${accum.getTotalArea()}")
    println("Sum perimeter: ${accum.getTotalPerimeter()}")

    println("Max area shape: ${accum.getMaxAreaShape()}")
    println("Max perimeter shape: ${accum.getMaxPerimeterShape()}")
    println("Min area shape: ${accum.getMinAreaShape()}")
    println("Min perimeter shape: ${accum.getMinPerimeterShape()}")

}