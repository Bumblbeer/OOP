package ru.etu.oop.lab6.fragments

import ru.etu.oop.lab6.models.CircleModel
import ru.etu.oop.lab6.validateFloat
import tornadofx.*

class CircleAddFragment : Fragment("New circle") {

    private val newCircle: CircleModel by inject()

    private var result = false

    fun getResult() = result

    override val root = form {
        fieldset("Circle parameters") {
            field("Radius") {
                textfield(newCircle.radius).validator {
                    when {
                        it.isNullOrBlank() ->
                            error("Radius is required")
                        !validateFloat(it) ->
                            error("Invalid float")
                        it.toFloat() == 0F || it.contains('-', true) ->
                             error("Radius must be positive")
                        else -> null
                    }
                }
            }
        }
        button("Create") {
            isDefaultButton = true
            enableWhen(newCircle.valid)
            action {
                result = true
                newCircle.commit { close() }
            }
        }
    }
}

