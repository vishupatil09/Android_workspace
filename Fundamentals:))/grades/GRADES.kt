fun main() {
    // Input marks for five subjects
    print("Enter Physics marks: ")
    val physics = readln().toInt()

    print("Enter Chemistry marks: ")
    val chemistry = readln().toInt()

    print("Enter Biology marks: ")
    val biology = readln().toInt()

    print("Enter Mathematics marks: ")
    val mathematics = readln().toInt()

    print("Enter Computer marks: ")
    val computer = readln().toInt()

    // Calculate total marks
    val totalMarks = physics + chemistry + biology + mathematics + computer

    // Calculate percentage
    val percentage = (totalMarks / (5 * 100.0)) * 100

    // Determine the grade based on the percentage
    val grade = when {
        percentage >= 90 -> "Grade A"
        percentage >= 80 -> "Grade B"
        percentage >= 70 -> "Grade C"
        percentage >= 60 -> "Grade D"
        percentage >= 40 -> "Grade E"
        else -> "Grade F"
    }

    // Print the results
    println("Total Marks: $totalMarks")
    println("Percentage: $percentage%")
    println("Grade: $grade")
}
