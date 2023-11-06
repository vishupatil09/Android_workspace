fun main() {
    print("Enter a number to check for divisibility by 11: ")
    val input = readln().toInt()


        try {
            val number = input

            val numberStr = number.toString()

            var oddSum = 0
            var evenSum = 0

            for (i in numberStr.indices) {
                val digit = numberStr[i].toString().toInt()
                if (i % 2 == 0) {
                    oddSum += digit
                } else {
                    evenSum += digit
                }
            }

            val difference = Math.abs(oddSum - evenSum)

            if (difference == 0 || difference % 11 == 0) {
                println("$number is divisible by 11.")
            } else {
                println("$number is not divisible by 11.")
            }
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a valid number.")
        }

}
