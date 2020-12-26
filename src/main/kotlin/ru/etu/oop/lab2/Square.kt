package ru.etu.oop.lab2
import java.lang.IllegalArgumentException

class Square(val side: Float) : Shape {

    init {
        if (side <= 0)
            throw IllegalArgumentException("Value of side can't be a non-positive value")
    }

    override fun getArea(): Float {
        return side * side
    }

    override fun getPerimeter(): Float {
        return 4 * side
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Square

        if (side != other.side) return false

        return true
    }

    override fun hashCode(): Int {
        return side.hashCode()
    }

    override fun toString(): String {
        return "Square(side=$side)"
    }
}