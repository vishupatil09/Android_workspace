fun main() {
    print("Enter the first number: ")
    val num1 = readln().toInt()

    print("Enter the second number: ")
    val num2 = readln().toInt()

    print("Enter the third number: ")
    val num3 = readln().toInt()

    if (num1 != null && num2 != null && num3 != null) {
        val greatest = maxOf(num1, num2, num3)
        val minimum = minOf(num1, num2, num3)

        println("Greatest number among $num1, $num2, and $num3 is $greatest.")
        println("Minimum number among $num1, $num2, and $num3 is $minimum.")
    } else {
        println("Invalid input. Please enter valid numbers.")
    }
}
