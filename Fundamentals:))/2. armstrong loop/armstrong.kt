fun main(){

    println(" what you want to use :   \n !. For Loop  \n 2. While Loop  \n 3.Calculate the Factorial \n4. give 5 numbers from user and find those numbers factorials \n 5.   Calculate sum of 10 numbers using of while loop" )

    var a= readln().toInt()

    when(a){


        1->{

            print("Enter a number: ")
            val number = readln().toInt()


                val originalNumber = number
                val numberOfDigits = number.toString().length
                var sum = 0

                for (digit in number.toString()) {
                    val digitValue = digit.toString().toInt()
                    sum += Math.pow(digitValue.toDouble(), numberOfDigits.toDouble()).toInt()
                }

                if (sum == originalNumber) {
                    println("$originalNumber is an Armstrong number.")
                } else {
                    println("$originalNumber is not an Armstrong number.")
                }

        }

        2->{

            print("Enter a number: ")
            val number = readln().toInt()

                val originalNumber = number
                val numberOfDigits = number.toString().length
                var sum = 0
                var temp = number

                while (temp != 0) {
                    val digit = temp % 10
                    sum += Math.pow(digit.toDouble(), numberOfDigits.toDouble()).toInt()
                    temp /= 10
                }

                if (sum == originalNumber) {
                    println("$originalNumber is an Armstrong number.")
                } else {
                    println("$originalNumber is not an Armstrong number.")
                }

        }

        3->{
            print("Enter a number: ")
            val number = readln().toInt()

                var factorial = 1

                for (i in 1..number) {
                    factorial *= i
                }

                println("Factorial of $number is $factorial")

        }
        4->{

                val factorials = mutableListOf<Long>()

                for (i in 1..5) {
                    print("Enter number $i: ")
                    val number = readln().toInt()

                    var factorial: Long = 1

                    for (i in 1..number) {
                        factorial *= i
                    }

                }

                println("Factorials of the numbers entered by the user:")
                for (i in 0 until factorials.size) {
                    println("Number ${i + 1}: ${factorials[i]}")
                }

        }
        5->{
            var sum = 0
            var count = 0

            while (count < 10) {
                print("Enter number ${count + 1}: ")
                val number = readln().toInt()


                    sum += number

            }

            println("Sum of the 10 numbers is: $sum")


        }
        else->
        {
            println(" enter the valid option !!!")
        }

    }



}