fun main()
{

    println(" select any one opration to perform:  ")

    println("1.Your year is leap year or not \n" +
            "2. Count no. of even numbers and no. of odd number \n" +
            "3. Count total sum of even number and total no. of odd numbers \n" +
            "4. Count total sum of positive number and total no. of negative numbers \n" +
            "5. Find maximum in 2 variable \n" +
            "6. Find minimum in 2 variable")

    var  a= readln().toInt()


    when(a){


        1->{
            print("Enter a year: ")
            val year = readln().toInt()

            if (year != null) {
                val isLeapYear = if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                {
                    true
                }
                else {
                    false
                }
                if (isLeapYear) {
                    println("$year is a leap year.")
                } else {
                    println("$year is not a leap year.")
                }
            } else {
                println("Invalid input. Please enter a valid year.")
            }


        }
        2->{
            print("Enter a list of numbers separated by spaces: ")
            val input = readLine()

            if (input != null) {
                val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }

                var evenCount = 0
                var oddCount = 0

                for (number in numbers) {
                    if (number % 2 == 0) {
                        evenCount++
                    } else {
                        oddCount++
                    }
                }

                println("Number of even numbers: $evenCount")
                println("Number of odd numbers: $oddCount")
            } else {
                println("Invalid input. Please enter a list of numbers separated by spaces.")
            }

        }
        3->{
            print("Enter a list of numbers separated by spaces: ")
            val input = readLine()

            if (input != null) {
                val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }

                var evenSum = 0
                var oddCount = 0

                for (number in numbers) {
                    if (number % 2 == 0) {
                        evenSum += number
                    } else {
                        oddCount++
                    }
                }

                println("Total sum of even numbers: $evenSum")
                println("Total number of odd numbers: $oddCount")
            } else {
                println("Invalid input. Please enter a list of numbers separated by spaces.")
            }

        }
        4->{
            print("Enter a list of numbers separated by spaces: ")
            val input = readLine()

            if (input != null) {
                val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }

                var positiveSum = 0
                var negativeCount = 0

                for (number in numbers) {
                    if (number > 0) {
                        positiveSum += number
                    } else if (number < 0) {
                        negativeCount++
                    }
                }

                println("Total sum of positive numbers: $positiveSum")
                println("Total number of negative numbers: $negativeCount")
            } else {
                println("Invalid input. Please enter a list of numbers separated by spaces.")
            }

        }
        5->{
            print("Enter the first number: ")
            val number1 = readLine()?.toDoubleOrNull()

            print("Enter the second number: ")
            val number2 = readLine()?.toDoubleOrNull()

            if (number1 != null && number2 != null) {
                val maximum = maxOf(number1, number2)

                println("The maximum number is $maximum.")
            } else {
                println("Invalid input. Please enter valid numbers.")
            }

        }
        6->{
            print("Enter the first number: ")
            val number1 = readLine()?.toDoubleOrNull()

            print("Enter the second number: ")
            val number2 = readLine()?.toDoubleOrNull()

            if (number1 != null && number2 != null) {
                val minimum = minOf(number1, number2)

                println("The minimum number is $minimum.")
            } else {
                println("Invalid input. Please enter valid numbers.")
            }

        }
        else->{

            println(" Enter Valid Option !!!")
        }
    }

}