fun main() {
    print("Enter the amount: ")
    val amount = readln().toInt()

    if (amount <= 0) {
        println("Invalid input. Please enter a positive amount.")
        return
    }

    var remainingAmount = amount
    var denomination: Int
    var count: Int

    println("Denominations for $amount:")

    denomination = 1000
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    denomination = 500
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    denomination = 100
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    denomination = 50
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    // 20s
    denomination = 20
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    // 10s
    denomination = 10
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    // 5s
    denomination = 5
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
        remainingAmount %= denomination
    }

    // 1s
    denomination = 1
    count = remainingAmount / denomination
    if (count > 0) {
        println("$denomination x $count")
    }
}

