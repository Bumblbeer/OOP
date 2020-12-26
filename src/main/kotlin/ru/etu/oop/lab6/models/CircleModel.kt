package ru.etu.oop.lab6.models

import ru.etu.oop.lab6.data.CircleData
import tornadofx.ItemViewModel

class CircleModel : ItemViewModel<CircleData>(CircleData()) {
    val radius = bind(CircleData::radiusData)
}