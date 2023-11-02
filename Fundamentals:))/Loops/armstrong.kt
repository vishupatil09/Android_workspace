fun main(){

    println(" what you want to use :   \n !. For Loop  \n 2. While Loop")

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

        else->
        {


            println(" enter the valid option !!!")
        }

    }



}