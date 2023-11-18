package patters

fun main() {

    println(" Enter the row  count : ")
    val n = readln().toInt()

    for (i in 0 until n) {
        for (j in 0 until n - i) {
            print(" ")
        }
        print("*")
        for (k in 0 until i * 2) {
            print(" ")
        }
        if (i > 0) {
            print("* ")
        }
        println()
    }

    // Lower part of the pattern
    for (i in n - 2 downTo 0) {
        for (j in 0 until n - i) {
            print(" ")
        }
        print("*")
        for (k in 0 until i * 2) {
            print(" ")
        }
        if (i > 0) {
            print("*")
        }
        println()
    }
}
