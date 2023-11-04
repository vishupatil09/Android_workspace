fun main()
{

    println("Select any one option \n 1. first last didgit sum: \n 2. all digit sum of :  \n 3. Generic Root of a Number ")

    var a = readln().toInt()


    when(a){

        1->{
            print("Enter an integer: ")
            val number = readln().toInt()
            var n = number

            var firstDigit =0

            while (n != 0) {
                firstDigit = n % 10
                n /= 10
            }
            val lastDigit = number.toString().last().toString().toInt()


            val sum = firstDigit+lastDigit
            println("Sum of the first and last digits of $number is: $sum")

        }
        2->
            {
                print("Enter an integer: ")
                val number = readln().toInt()
                var n = number
                var  sum =0

                while (n != 0) {
                    val digit = n % 10
                    sum += digit
                    n /= 10
                }

                    val total = sum
                    println("Sum of all digits in $number is: $total")

            }

        3->{
            print("Enter an integer: ")
            val number = readln().toInt()
            var n = number
            var  sum =0

            while (n != 0) {
                val digit = n % 10
                sum += digit
                n /= 10
                    if (n ==0){

                                if(sum>9)
                                {
                                    n = sum
                                    sum = 0
                                }
                            }
                }
            println("Generic Root of $number is $sum")

        }

        else->{

            println("Enter The valid Option !!!")
        }
    }



}
