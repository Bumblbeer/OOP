package ru.etu.oop.lab2
import java.lang.IllegalArgumentException

class Rectangle(val width: Float, val height: Float) : Shape {

    init {
        if (width <= 0 || height <= 0)
            throw IllegalArgumentException("There is a non-natural value of a side of the shape")
    }

    override fun getArea(): Float {
        return width * height
    }

    override fun getPerimeter(): Float {
        return 2 * (width + height)
    }

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }

    //Auto-generated overrides
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + height.hashCode()
        return result
    }
}