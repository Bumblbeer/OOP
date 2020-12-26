package ru.etu.oop.lab6.models

import ru.etu.oop.lab6.data.TriangleData
import tornadofx.ItemViewModel

class TriangleModel: ItemViewModel<TriangleData>(TriangleData()) {
    val side1 = bind(TriangleData::side1Data)
    val side2 = bind(TriangleData::side2Data)
    val side3 = bind(TriangleData::side3Data)
}
