import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class Matrix(inputElements: Array<Array<Double>>) {

    // Immutable copy of input arrays
    private val items = inputElements.copyOf().map { array -> array.copyOf() }

    init {
        validate()
    }

    // Initializes the Matrix of nulls
    constructor(width: Int, height: Int): this(Array(height) { Array(width) { 0.0 } })

    // Checks if the Matrix is correct
    private fun validate() {
        if (items.isEmpty()) return

        items.forEach {
            if (it.size != width) {
                throw IllegalStateException()
            }
        }
    }

    // Setter
    operator fun set(i: Int, j: Int, element: Double) {
        items[i][j] = element
    }

    // Getter
    operator fun get(i: Int, j: Int): Double {
        return items[i][j]
    }

    val height: Int
        get() {
            return items.size
        }

    val width: Int
        get() {
            if (items.isEmpty()) return 0
            return items[0].size
        }

    private inline fun iterate(callback: (i: Int, j: Int, element: Double) -> Unit) {
        items.forEachIndexed { i, Doubles ->
            Doubles.forEachIndexed { j, element ->
                callback(i, j, element);
            }
        }
    }

    private inline fun iterateWithAction(callback: (i: Int, j: Int, element: Double) -> Double) {
        iterate { i, j, element -> this[i, j] = callback(i, j, element) }
    }

    private inline fun doThrough(callback: (i: Int, j: Int) -> Double): Matrix {
        val result = Matrix(width, height)
        result.iterateWithAction { i, j, _ -> callback(i, j) }
        return result
    }

    private fun areSameDims(matrix: Matrix) {
        if (matrix.height != height || matrix.width != width) {
            throw IllegalArgumentException()
        }
    }

    private fun areSameRotatedDims(matrix: Matrix) {
        if (width != matrix.height || height != matrix.width) {
            throw IllegalArgumentException()
        }
    }

    private fun isSquare() {
        if (width != height) {
            throw IllegalStateException()
        }
    }

    // Overrides +
    operator fun plus(matrix: Matrix): Matrix {
        areSameDims(matrix)
        return doThrough { i, j -> this[i, j] + matrix[i, j] }
    }

    // Overrides -
    operator fun minus(matrix: Matrix): Matrix {
        areSameDims(matrix)
        return doThrough { i, j -> this[i, j] - matrix[i, j] }
    }

    // Overrides * number
    operator fun times(number: Double): Matrix {
        return doThrough { i, j -> this[i, j] * number }
    }

    // Overrides * Matrix
    operator fun times(matrix: Matrix): Matrix {
        areSameRotatedDims(matrix)
        return doThrough { i, j -> this[i, j] + matrix[j, i] }
    }

    val determinant: Double
        get() {
            isSquare()

            val l = Matrix(width, height)
            val u = Matrix(width, height)

            iterate { i, _, _ -> l[i, i] = 1.0 }

            iterate { i, j, element ->
                if (i <= j) {
                    u[i, j] = element - Array(i) { k -> l[i, k] * u[k, j] }.sum()
                } else {
                    l[i, j] = (element - Array(j) { k -> l[i, k] * u[k, j] }.sum()) / u[j, j]
                }
            }

            var detL = 1.0
            var detU = 1.0

            for (i in 0 until width) {
                detL *= l[i, i]
                detU *= u[i, i]
            }

            return detL * detU
        }

    // Overrides = for boolean expressions
    override operator fun equals(other: Any?): Boolean {
        if (other !is Matrix) return false
        return hashCode() == other.hashCode()
    }

    override fun hashCode(): Int {
        return items.hashCode()
    }

    override fun toString(): String {
        var output = ""
        iterate { _, j, element ->
            output += element.toString() + if (j != width - 1) " " else "\n"
        }
        return output
    }
}
