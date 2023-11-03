fun main(){

    println(" Select any one option you want  to perform :  \n 1.the Sum of Natural Numbers Using the While Loop  \n 2.calculate number of even and\n" +
            "odd using of while loop")



    var a = readln().toInt()

    when(a){


        1->{
            print("Enter a positive integer: ")
            val n = readln().toInt()

                var sum = 0
                var i = 1

                while (i <= n) {
                    sum += i
                    i++
                }

                println("The sum of the first $n natural numbers is: $sum")

        }
        2->{
            var evenCount = 0
            var oddCount = 0
            var count = 0

            while (count < 5) {
                print("Enter number ${count + 1}: ")
                val number = readln().toInt()

                    if (number % 2 == 0) {
                        evenCount++
                    } else {
                        oddCount++
                    }
                    count++

            }

            println("Number of even numbers: $evenCount")
            println("Number of odd numbers: $oddCount")

        }
        else->{
            println(" Enter the valid option !!!")
        }
    }


}