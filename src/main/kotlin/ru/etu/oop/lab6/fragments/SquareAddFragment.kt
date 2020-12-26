package ru.etu.oop.lab6.fragments

import ru.etu.oop.lab6.models.SquareModel
import ru.etu.oop.lab6.validateFloat
import tornadofx.*

class SquareAddFragment: Fragment("New square") {
    private val newSquare: SquareModel by inject()

    private var result = false

    fun getResult() = result

    override val root = form {
        fieldset("Square parameters") {
            field("Side") {
                textfield(newSquare.side).validator {
                    when {
                        it.isNullOrBlank() ->
                            error("Radius is required")
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
            enableWhen(newSquare.valid)
            action {
                result = true
                newSquare.commit { close() }
            }
        }
    }

}
