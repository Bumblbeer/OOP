fun main() {

    val rectWidth = 5.0F
    val rectHeight = 3.0F
    val rectangle = Rectangle(rectWidth, rectHeight)

    val squareSize = 3.0F
    val square = Square(squareSize)

    val trSize1 = 4.0F
    val trSize2 = 3.0F
    val trSize3 = 5.0F
    val triangle = Triangle(trSize1, trSize2, trSize3)

    val circleR = 4.0F
    val circle = Circle(circleR)

    val shapesList = mutableListOf(rectangle, square, triangle, circle)

    println(shapesList.minByOrNull { shape -> shape.getArea() })
    println(shapesList.minByOrNull { shape -> shape.getPerimeter() })
    println(shapesList.map { shape -> shape.getArea() }.sum())

}