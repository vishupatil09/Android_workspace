fun main() {
    print("Enter the first number: ")
    val number1 = readLine()?.toDoubleOrNull()

    print("Enter the second number: ")
    val number2 = readLine()?.toDoubleOrNull()

    if (number1 != null && number2 != null) {
        val sum = number1 + number2

        println("Sum of $number1 and $number2 is $sum.")

        val sumSize = when {
            sum < Int.MIN_VALUE || sum > Int.MAX_VALUE -> "Larger than an Int"
            sum < Short.MIN_VALUE || sum > Short.MAX_VALUE -> "Larger than a Short"
            sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE -> "Larger than a Byte"
            else -> "Fits within Int"
        }

        println("The size of the sum is $sumSize.")
    } else {
        println("Invalid input. Please enter valid numbers.")
    }
}
