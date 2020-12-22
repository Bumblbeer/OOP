package ru.etu.oop.lab1

fun main() {
    val matrix1 = Matrix(arrayOf(
        arrayOf(1.0, 2.0, 3.0),
        arrayOf(4.0, 5.0, 6.0),
        arrayOf(7.0, 8.0, 9.0)
    ))

    val matrix2 = Matrix(arrayOf(
        arrayOf(9.0, 8.0, 7.0),
        arrayOf(6.0, 5.0, 4.0),
        arrayOf(3.0, 2.0, 1.0)
    ))

    println(matrix1)
    /*
    1.0 2.0 3.0
    4.0 5.0 6.0
    7.0 8.0 9.0
    */

    println(matrix2)
    /*
    9.0 8.0 7.0
    6.0 5.0 4.0
    3.0 2.0 1.0
    */

    println(matrix1.width)
    // 3

    println(matrix1.height)
    //3

    println(matrix1.determinant)
    // -0.0

    println(matrix1 == matrix2)
    // false

    println(matrix1 + matrix2)
    /*
    10.0 10.0 10.0
    10.0 10.0 10.0
    10.0 10.0 10.0
    */

    println(matrix1 - matrix2)
    /*
    -8.0 -6.0 -4.0
    -2.0 0.0 2.0
    4.0 6.0 8.0
    */

    println(matrix1 * matrix2)
    /*
    10.0 8.0 6.0
    12.0 10.0 8.0
    14.0 12.0 10.0
    */

    println(matrix1 * 100.0)
    /*
    100.0 200.0 300.0
    400.0 500.0 600.0
    700.0 800.0 900.0
    */
}