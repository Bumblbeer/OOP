package ru.etu.oop.lab6.fragments

import ru.etu.oop.lab6.isFloatZero
import ru.etu.oop.lab6.models.TriangleModel
import ru.etu.oop.lab6.validateFloat
import tornadofx.*

class TriangleAddFragment: Fragment("New triangle") {
    val newTriangle: TriangleModel by inject()

    private var result = false

    fun getResult() = result

    private fun isTriangleValid(): Boolean {
        val side1 = newTriangle.side1.value.toFloat()
        val side2 = newTriangle.side2.value.toFloat()
        val side3 = newTriangle.side3.value.toFloat()
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1
    }

    override val root = form {
        fieldset("Triangle parameters") {
            field("First Side") {
                textfield(newTriangle.side1).validator {
                    when {
                        it.isNullOrBlank() -> error("Required field")
                        it.isNullOrEmpty() -> error("Required field")
                        !validateFloat(it) -> error("Invalid float")
                        isFloatZero(it) || it.contains('-', true) ->
                            error("Side must be positive")
                        !isTriangleValid() -> error("This triangle can not exist")
                        else -> null
                    }
                }
                newTriangle.side1.onChange {
                    if (it !== null)
                    newTriangle.validate(false, true)
                }
            }
            field("Second Side") {
                textfield(newTriangle.side2).validator {
                    when {
                        it.isNullOrBlank() -> error("Required field")
                        it.isNullOrEmpty() -> error("Required field")
                        !validateFloat(it) -> error("Invalid float")
                        isFloatZero(it) || it.contains('-', true) ->
                            error("Side must be positive")
                        !isTriangleValid() -> error("This triangle can not exist")
                        else -> null
                    }
                }
                newTriangle.side2.onChange {
                    if (it !== null)
                    newTriangle.validate(false, true)
                }
            }
            field("Third Side") {
                textfield(newTriangle.side3).validator {
                    when {
                        it.isNullOrBlank() -> error("Required field")
                        it.isNullOrEmpty() -> error("Required field")
                        !validateFloat(it) -> error("Invalid float")
                        isFloatZero(it) || it.contains('-', true) ->
                            error("Side must be positive")
                        !isTriangleValid() -> error("This triangle can not exist")
                        else -> null
                    }
                }
                newTriangle.side3.onChange {
                    if (it !== null)
                    newTriangle.validate(false, true)
                }
            }
        }
        button("Create") {
            isDefaultButton = true
            enableWhen(newTriangle.valid)
            action {
                result = true
                newTriangle.commit { close() }
            }
        }
    }
}