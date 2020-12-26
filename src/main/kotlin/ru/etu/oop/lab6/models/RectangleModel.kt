package ru.etu.oop.lab6.models

import ru.etu.oop.lab6.data.RectangleData
import tornadofx.ItemViewModel

class RectangleModel: ItemViewModel<RectangleData>(RectangleData()) {
    val width = bind(RectangleData::widthData)
    val height = bind(RectangleData::heightData)
}