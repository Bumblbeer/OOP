package ru.etu.oop.lab6
import tornadofx.*

class MainApp : App (MainView::class) {
    val controller: MainController by inject()

    override fun stop() {
        controller.save()
        super.stop()
    }
}

fun main() {
    launch<MainApp>()
}