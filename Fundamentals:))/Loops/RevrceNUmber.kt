fun main() {
    print("Enter a number: ")
    val number = readln().toInt()


        var originalNumber = number
        var reversedNumber = 0

        for (i in number.toString().reversed()) {
            reversedNumber = reversedNumber * 10 + i.toString().toInt()
        }

        println("Original Number: $originalNumber")
        println("Reversed Number: $reversedNumber")

}
