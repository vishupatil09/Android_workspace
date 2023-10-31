import kotlin.system.exitProcess

fun main() {

        var Calculatio = true

        while (Calculatio) {
            println("Select an operation:")
            println("1. Calculate Area")
            println("2. Calculate Circumference")
            println("3. Exit")
            print("Enter your choice (1, 2, or 3): ")

            val choice = readLine()?.toIntOrNull()

            when (choice) {
                1 -> Area()
                2 -> Circumference()
                3 -> {
                    println("Exiting the program.")
                    Calculatio = false
                }
                else -> println("Invalid choice.")
            }
        }
    }

    fun Area() {
        var Calculation = true

        while (Calculation) {
            println("Select a shape for area calculation:")
            println("1. Square")
            println("2. Cube")
            println("3. Triangle")
            println("4. Rectangle")
            println("5. Rectangular Prism")
            println("6. Back to Main Menu")
            print("Enter your choice (1-6): ")

            val shapeChoice = readLine()?.toIntOrNull()

            when (shapeChoice) {
                1 -> {
                    // Square
                    print("Enter the side length of the square: ")
                    val a = readLine()?.toDouble() ?: 0.0
                    val area = a * a
                    println("Area of Square: $area")
                    ReturnMenu()
                }
                2 -> {
                    // Cube
                    print("Enter the side length of the square: ")
                    val a = readLine()?.toDouble() ?: 0.0
                    val area = 6*a*2
                    println("Area of Cube: $area")
                    ReturnMenu()
                }
                3 -> {
                    //Triangle
                    print("Enter the side length of the Triangle: ")
                    var b = readln().toInt()
                    print("Enter the base length of the Triangle: ")
                    var h = readln().toInt()
                    var  A = 1/2 * b * h
                    println("Area of Triangle: $A")
                    ReturnMenu()

                }

                4 ->
                {
                    //rectangle
                    print("Enter the width length of the Rectangle: ")
                    var b = readln().toInt()
                    print("Enter the length of the Rectangle: ")
                    var h = readln().toInt()
                    var  A = b*h
                    println("Area of Rectangle: $A")
                    ReturnMenu()

                }
                5 ->
                {
                    //rectangle prism
                    print("Enter the width length of the Rectangle: ")
                    var w = readln().toInt()
                    print("Enter the length of the Rectangle: ")
                    var l = readln().toInt()
                    print("Enter the hight length of the Rectangle: ")
                    var h = readln().toInt()

                    var prism = 2*((w*l)+(h*l)+(h*w))

                    println("Area of a Rectangular Prism: $prism")
                    ReturnMenu()

                }

                6 ->  {
                    println("Returning to the main menu.")
                    Calculation = false
                }
            }
        }
    }

    fun Circumference() {
        var continueCalculation = true

        while (continueCalculation) {
            println("Select a shape for circumference calculation:")
            println("1. Rectangle")
            println("2. Triangle")
            println("3. Square")
            println("4. Back to Main Menu")
            print("Enter your choice (1-4): ")

            val shapeChoice = readLine()?.toIntOrNull()

            when (shapeChoice) {
                1 -> {
                    // Circumference of Rectangle
                    print("Enter the side length of the rectangle: ")
                    val a = readLine()?.toDouble() ?: 0.0
                    val circumference = 4 * a
                    println("Circumference of Rectangle: $circumference")
                    ReturnMenu()
                }
                2 -> {
                    // Circumference of Triangle
                    print("Enter the width length of the Rectangle: ")
                    var w = readln().toInt()
                    print("Enter the length of the Rectangle: ")
                    var l = readln().toInt()
                    print("Enter the hight length of the Rectangle: ")
                    var h = readln().toInt()

                    var triangle = w+h+l
                    println("Circumference of Triangle: $triangle")
                    ReturnMenu()

                }
                3 -> {
                    // Circumference of Squeare
                    print("Enter the side length of the Sqeare: ")
                    val a = readln().toInt()
                    val circumference = 4*a
                    println("Circumference of Squeare: $circumference")
                    ReturnMenu()


                }
                4 -> {
                    println("Returning to the main menu.")
                    continueCalculation = false
                }

            }
        }
    }

    fun ReturnMenu() {
        print("Do you want to perform another calculation? (y/n): ")
        val input = readLine()

        if (input.equals("n", true)) {
            println("Exiting the program.")
            exitProcess(143)


        } else if (!input.equals("y", true)) {
            println("Invalid choice. Returning to the main menu.")
        }
    }

