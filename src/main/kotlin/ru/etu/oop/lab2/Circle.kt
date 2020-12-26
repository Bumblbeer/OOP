package ru.etu.oop.lab2
import java.lang.IllegalArgumentException
import kotlin.math.*

class Circle(val radius: Float) : Shape {
    init {
        if (radius <= 0)
            throw IllegalArgumentException("Radius can't be a non-positive value")
    }

    override fun getArea(): Float {
        return PI.toFloat() * radius.pow(2.0F)
    }

    override fun getPerimeter(): Float {
        return 2 * PI.toFloat() * radius
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        return radius.hashCode()
    }

    override fun toString(): String {
        return "Circle(radius=$radius)"
    }

}