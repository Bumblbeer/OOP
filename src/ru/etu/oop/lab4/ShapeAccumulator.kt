package ru.etu.oop.lab4
import ru.etu.oop.lab2.Shape

class ShapeAccumulator {
    private val shapesList = mutableListOf<Shape>()

    fun add(shape: Shape) {
        shapesList.add(shape)
    }

    fun addAll(shapesCol : Collection<Shape>) {
        shapesList.addAll(shapesCol)
    }

    fun getMaxAreaShape(): Shape? {
        return shapesList.maxByOrNull { shape -> shape.getArea() }
    }

    fun getMinAreaShape() : Shape? {
        return shapesList.minByOrNull { shape -> shape.getArea() }
    }

    fun getMaxPerimeterShape() : Shape? {
        return shapesList.maxByOrNull { shape -> shape.getPerimeter() }
    }

    fun getMinPerimeterShape() : Shape? {
        return shapesList.minByOrNull { shape -> shape.getPerimeter() }
    }

    fun getTotalArea() : Float {
        return shapesList.map { shape -> shape.getArea() }.sum()
    }

    fun getTotalPerimeter() : Float {
        return shapesList.map { shape -> shape.getPerimeter() }.sum()
    }
}