fun  main(){

    println(" select any one to perform:  ")

    println("1.Given Date Month and the Year Is Correct or Not Using If-Else \n" +
            "2. to input the week number and print week day.\n" +
            "3. Accept month number and display month name \n" +
            "4. Accept the input month number and print number of days in that month")

    var a = readln().toInt()

    when(a){



        1->{
                print("Enter a year (e.g., 2023): ")
                val year = readLine()?.toIntOrNull()

                print("Enter a month (1-12): ")
                val month = readLine()?.toIntOrNull()

                print("Enter a day (1-31): ")
                val day = readLine()?.toIntOrNull()

                if (year != null && month != null && day != null) {
                    val isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

                    if (month in 1..12 && day in 1..31) {
                        val daysInMonth = when (month) {
                            1, 3, 5, 7, 8, 10, 12 -> 31
                            4, 6, 9, 11 -> 30
                            2 -> if (isLeapYear) 29 else 28
                            else -> 0
                        }

                        if (day <= daysInMonth) {
                            println("The date $day/$month/$year is a valid date.")
                        } else {
                            println("Invalid day for the given month.")
                        }
                    } else {
                        println("Invalid month or day.")
                    }
                } else {
                    println("Invalid input. Please enter valid year, month, and day.")
                }
        }
        2->
            {
                print("Enter a week number (1-7): ")
                val weekNumber = readLine()?.toIntOrNull()

                if (weekNumber != null && weekNumber in 1..7) {
                    val dayOfWeek = when (weekNumber) {
                        1 -> "Sunday"
                        2 -> "Monday"
                        3 -> "Tuesday"
                        4 -> "Wednesday"
                        5 -> "Thursday"
                        6 -> "Friday"
                        7 -> "Saturday"
                        else -> "Invalid week number"
                    }

                    println("Day of the week for week $weekNumber is $dayOfWeek.")
                } else {
                    println("Invalid input. Please enter a valid week number (1-7).")
                }

            }


        3->
            {
                print("Enter a month number (1-12): ")
                val monthNumber = readLine()?.toIntOrNull()

                if (monthNumber != null && monthNumber in 1..12) {
                    val monthName = when (monthNumber) {
                        1 -> "January"
                        2 -> "February"
                        3 -> "March"
                        4 -> "April"
                        5 -> "May"
                        6 -> "June"
                        7 -> "July"
                        8 -> "August"
                        9 -> "September"
                        10 -> "October"
                        11 -> "November"
                        12 -> "December"
                        else -> "Invalid month number"
                    }

                    println("Month name for month $monthNumber is $monthName.")
                } else {
                    println("Invalid input. Please enter a valid month number (1-12).")
                }

            }


        4->
            {
                print("Enter a month number (1-12): ")
                val monthNumber = readLine()?.toIntOrNull()

                if (monthNumber != null && monthNumber in 1..12) {
                    val daysInMonth = when (monthNumber) {
                        1, 3, 5, 7, 8, 10, 12 -> 31
                        4, 6, 9, 11 -> 30
                        2 -> 28 // Assuming a non-leap year
                        else -> 0 // Invalid month number
                    }

                    if (daysInMonth > 0) {
                        println("Number of days in month $monthNumber is $daysInMonth.")
                    } else {
                        println("Invalid month number.")
                    }
                } else {
                    println("Invalid input. Please enter a valid month number (1-12).")
                }


            }
        else->{
            println(" Enter The valid Option !!!")
        }
    }



}