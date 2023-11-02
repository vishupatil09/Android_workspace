fun main() {
    val names = mutableListOf<String>()

    for (i in 1..5) {
        print("Enter name $i: ")
        val name = readLine().toString()
        if (!name.isNullOrBlank()) {
            names.add(name)
        } else {
            println("Invalid input. Please enter a valid name.")
            break
        }
    }

    println("Names entered by the user:")
    names.forEach { println(it) }
}
