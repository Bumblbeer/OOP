package ru.etu.oop.lab6.fragments

import ru.etu.oop.lab6.models.RectangleModel
import ru.etu.oop.lab6.validateFloat
import tornadofx.*

class RectangleAddFragment: Fragment("New square") {
    private val newRectangle: RectangleModel by inject()

    private var result = false

    fun getResult() = result

    override val root = form {
        fieldset("Rectangle parameters") {
            field("Width") {
                textfield(newRectangle.width).validator {
                    when {
                        it.isNullOrBlank() ->
                            error("Width is required")
                        !validateFloat(it) ->
                            error("Invalid float")
                        it.toFloat() == 0F || it.contains('-', true) ->
                            error("Side must be positive")
                        else -> null
                    }
                }
            }
            field("Height") {
                textfield(newRectangle.height).validator {
                    when {
                        it.isNullOrBlank() ->
                            error("Height is required")
                        !validateFloat(it) ->
                            error("Invalid float")
                        it.toFloat() == 0F || it.contains('-', true) ->
                            error("Side must be positive")
                        else -> null
                    }
                }
            }
        }
        button("Create") {
            isDefaultButton = true
            enableWhen(newRectangle.valid)
            action {
                result = true
                newRectangle.commit { close() }
            }
        }
    }

}
