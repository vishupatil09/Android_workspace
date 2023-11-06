fun main() {
    val days = 31
    val startDay = 0 // Assuming it starts on Sunday

    println("Sun Mon Tue Wed Thu Fri Sat")

    for (day in 1..days) {

        print("${day.toString().padStart(3)} ")

        if ((day + startDay) % 7 == 0) {
            println()
        }
    }
}
