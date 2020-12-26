package ru.etu.oop.lab6

import tornadofx.*
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.stage.FileChooser
import ru.etu.oop.lab5.*
import ru.etu.oop.lab2.*
import ru.etu.oop.lab6.fragments.CircleAddFragment
import ru.etu.oop.lab6.fragments.RectangleAddFragment
import ru.etu.oop.lab6.fragments.SquareAddFragment
import ru.etu.oop.lab6.fragments.TriangleAddFragment
import ru.etu.oop.lab6.models.CircleModel
import ru.etu.oop.lab6.models.RectangleModel
import ru.etu.oop.lab6.models.SquareModel
import ru.etu.oop.lab6.models.TriangleModel

class MainView : View("Shape modifier") {
    val controller: MainController by inject()
    val label = Label()
    private var shapeListView: ListView<Shape> = listview(controller.shapesList)
    override val root = borderpane {
        center = shapeListView
        right = vbox(5) {
            val sidemargin = 5.0
            hbox(5) {
                button("Move up") {
                    useMaxWidth = true
                    action {
                        val selectedArray = shapeListView.selectionModel.selectedIndices // Moving an item in list
                        if (selectedArray.isNotEmpty()) {
                            val selectedItem = selectedArray[0]
                            controller.moveUp(selectedItem)
                            if (selectedItem != 0)
                                shapeListView.selectionModel.select(selectedItem - 1) // Moving the selection
                        }
                    }
                    hboxConstraints {
                        marginLeft = sidemargin
                        marginRight = sidemargin / 2
                        marginTop = sidemargin
                    }
                }
                button("Move down") {
                    useMaxWidth = true
                    action {
                        val selectedArray = shapeListView.selectionModel.selectedIndices
                        if (selectedArray.isNotEmpty()) {
                            val selectedItem = selectedArray[0]
                            controller.moveDown(selectedItem)
                            if (selectedItem != shapeListView.items.size - 1)
                                shapeListView.selectionModel.select(selectedItem + 1)
                        }
                    }
                    hboxConstraints {
                        marginLeft = sidemargin / 2
                        marginRight = sidemargin
                        marginTop = sidemargin
                    }
                }
            }
            button("Add a circle") {
                useMaxWidth = true
                action {
                    val circleModel = CircleModel()
                    val scope = Scope(circleModel)
                    val modal = find<CircleAddFragment>(scope).apply { openModal(block = true) }
                    val success = modal.getResult()

                    if (success) {
                        val radius = circleModel.item.radiusData.value
                        val newCircle = Circle(radius)

                        controller.add(newCircle)
                    }
                }
                vboxConstraints {
                    marginLeft = sidemargin
                    marginRight = sidemargin
                }
            }
            button("Add a rectangle") {
                useMaxWidth = true
                action {
                    val rectangleModel = RectangleModel()
                    val scope = Scope(rectangleModel)
                    val modal = find<RectangleAddFragment>(scope).apply { openModal(block = true) }
                    val success = modal.getResult()

                    if (success) {
                        val width = rectangleModel.item.widthData.value
                        val height = rectangleModel.item.heightData.value
                        val newRectangle = Rectangle(width, height)
                        controller.add(newRectangle)
                    }
                    vboxConstraints {
                        marginLeft = sidemargin
                        marginRight = sidemargin
                    }
                }
                vboxConstraints {
                    marginLeft = sidemargin
                    marginRight = sidemargin
                }
            }
            button("Add a square") {
                useMaxWidth = true
                action {
                    val squareModel = SquareModel()
                    val scope = Scope(squareModel)
                    val modal = find<SquareAddFragment>(scope).apply { openModal(block = true) }
                    val success = modal.getResult()

                    if (success) {
                        val side = squareModel.item.sideData.value
                        val newSquare = Square(side)
                        controller.add(newSquare)
                    }

                }
                vboxConstraints {
                    marginLeft = sidemargin
                    marginRight = sidemargin
                }
            }
            button("Add a triangle") {
                useMaxWidth = true
                action {
                    val triangleModel = TriangleModel()
                    val scope = Scope(triangleModel)
                    val modal = find<TriangleAddFragment>(scope).apply { openModal(block = true) }
                    val success = modal.getResult()

                    if (success) {
                        val side1 = triangleModel.item.side1Data.value
                        val side2 = triangleModel.item.side2Data.value
                        val side3 = triangleModel.item.side3Data.value
                        val newTriangle = Triangle(side1, side2, side3)
                        controller.add(newTriangle)
                    }
                }
                vboxConstraints {
                    marginLeft = sidemargin
                    marginRight = sidemargin
                }
            }
            button("Remove shape") {
                useMaxWidth = true
                action {
                    val selectedArray = shapeListView.selectionModel.selectedIndices
                    if (selectedArray.isNotEmpty()) {
                        val selectedItem = selectedArray[0]
                        controller.shapesList.removeAt(selectedItem)
                    }
                }
                vboxConstraints {
                    marginLeft = sidemargin
                    marginRight = sidemargin
                }
            }
            vbox(5) {
                button("Save list") {
                    useMaxWidth = true
                    action {
                        controller.save()
                    }
                    vboxConstraints {
                        marginLeft = sidemargin
                        marginRight = sidemargin
                        marginTop = 10.0
                    }
                }
                button("Open file") {
                    useMaxWidth = true
                    action {
                        controller.open()
                    }
                    vboxConstraints {
                        marginLeft = sidemargin
                        marginRight = sidemargin
                    }
                }
            }
        }
    }
}