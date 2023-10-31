
fun main(){


println("Enter The Value Of Character : ")

        val asciiCode = readln().toInt()
        var character = asciiCode.toChar()
        println("Character for ASCII code $asciiCode is: $character")

    print("Enter a character: ")
    val input = readLine()

    if (input != null && input.length == 1) {
        val character = input[0]
        val asciiCode = character.toInt()
        println("ASCII code for the character '$character' is: $asciiCode")
    } else {
        println("Invalid input. Please enter a single character.")
    }


}