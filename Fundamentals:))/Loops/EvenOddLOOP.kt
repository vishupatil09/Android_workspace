fun main() {
    var evenCount = 0
    var oddCount = 0

    for (i in 1..10) {
        print("Enter number $i: ")
        val number = readln().toInt()

        if (number != null) {
            if (number % 2 == 0) {
                evenCount++
            } else {
                oddCount++
            }
        } else {
            println("Invalid input. Please enter a valid number.")
        }
    }

    println("Number of even numbers: $evenCount")
    println("Number of odd numbers: $oddCount")
}
