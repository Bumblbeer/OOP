package ru.etu.oop.lab2
import java.lang.IllegalArgumentException
import kotlin.math.sqrt

class Triangle(val side1: Float, val side2: Float, val side3: Float ) : Shape {
    init {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw IllegalArgumentException("There's a non-natural value of a side")
    }

    override fun getArea(): Float {
        val s : Float = (side1 + side2 + side3) / 2
        return sqrt(s * (s - side1) * (s - side2) * (s - side3))
    }

    override fun getPerimeter(): Float {
        return side1 + side2 + side3
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Triangle

        if (side1 != other.side1) return false
        if (side2 != other.side2) return false
        if (side3 != other.side3) return false

        return true
    }

    override fun hashCode(): Int {
        var result = side1.hashCode()
        result = 31 * result + side2.hashCode()
        result = 31 * result + side3.hashCode()
        return result
    }

    override fun toString(): String {
        return "Triangle(side1=$side1, side2=$side2, side3=$side3)"
    }
}