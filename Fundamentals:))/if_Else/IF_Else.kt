fun main (){

    println(" Select any one opration to perform ")
    println("-------------------------------------------------------------------------------------------------------")
    println("1.Find the Character Is Vowel or Not\n" +
            "2.Check pass or fail \n" +
            "3.To Check Uppercase or Lowercase or Digit or Special \n" +
            "Character\n" +
            "4.To check whether a number is negative, positive or zero")
    var a = readln().toInt()

    when(a){

        1->{
            print("Enter a character: ")
            val input = readLine()

            if (input != null && input.length == 1) {
                val char = input[0].toLowerCase() // Convert to lowercase for case-insensitive check

                val isVowel = when (char) {
                    'a', 'e', 'i', 'o', 'u' -> true
                    else -> false
                }

                if (isVowel) {
                    println("$char is a vowel.")
                } else {
                    println("$char is not a vowel.")
                }
            } else {
                println("Invalid input. Please enter a single character.")
            }

        }
        2->{
            print("Enter the marks: ")
            val marks = readLine()?.toDoubleOrNull()

            if (marks != null) {
                val passing = 35.0 // You can change the passing threshold as needed

                if (marks >= passing) {
                    println("Pass")
                } else {
                    println("Fail")
                }
            } else {
                println("Invalid input. Please enter valid marks.")
            }

        }
        3->{
            print("Enter a character: ")
            val input = readLine()

            if (input != null && input.length == 1) {
                val char = input[0]

                val category = when {
                    char.isUpperCase() -> "Uppercase"
                    char.isLowerCase() -> "Lowercase"
                    char.isDigit() -> "Digit"
                    else -> "Special Character"
                }

                println("$char is a $category.")
            } else {
                println("Invalid input. Please enter a single character.")
            }

        }
        4->{
            print("Enter a number: ")
            val number = readLine()?.toDoubleOrNull()

            if (number != null) {
                val result = when {
                    number > 0 -> "Positive"
                    number < 0 -> "Negative"
                    else -> "Zero"
                }

                println("The number is $result.")
            } else {
                println("Invalid input. Please enter a valid number.")
            }

        }

        else->{

            println(" enter valid option !!!")
        }

    }





}