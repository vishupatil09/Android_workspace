fun main() {
    print("Enter the basic salary of the employee: ")
    val basicSalary = readln().toInt()

    if (basicSalary != null) {
        val hra: Double
        val da: Double

        when {
            basicSalary <= 10000 -> {
                hra = 0.2 * basicSalary
                da = 0.8 * basicSalary
            }
            basicSalary <= 20000 -> {
                hra = 0.25 * basicSalary
                da = 0.9 * basicSalary
            }
            else -> {
                hra = 0.3 * basicSalary
                da = 0.95 * basicSalary
            }
        }

        val grossSalary = basicSalary + hra + da

        println("Basic Salary: $basicSalary")
        println("HRA: $hra")
        println("DA: $da")
        println("Gross Salary: $grossSalary")
    } else {
        println("Invalid input. Please enter a valid basic salary.")
    }
}
