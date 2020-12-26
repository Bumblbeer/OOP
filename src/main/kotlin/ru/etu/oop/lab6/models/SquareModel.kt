package ru.etu.oop.lab6.models

import ru.etu.oop.lab6.data.SquareData
import tornadofx.ItemViewModel

class SquareModel : ItemViewModel<SquareData>(SquareData()) {
    val side = bind(SquareData::sideData)
}