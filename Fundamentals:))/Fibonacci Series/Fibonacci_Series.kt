fun main(){

    println("Select any one option to perform :  \n------------------------------------------------------------------- \n \n 1.Fibonacci Series Program using do while  \n \n 2. Find the GCD of Two Numbers Using Loop \n \n 3.Accept 5 numbers from user and find each numbers factorial")
     var a = readln().toInt()

    when(a){

        1->{

                print("Enter the number of terms for the Fibonacci series: ")
                val n = readLine()!!.toInt()

                    if (n >= 2) {
                        var first = 0
                        var second = 1

                        println("Fibonacci Series:")
                        print("$first, $second")

                        var i = 2
                        do {
                            val next = first + second
                            print(", $next")
                            first = second
                            second = next
                            i++
                        }
                        while (i < n)

                        println()
                    } else {
                        println("Fibonacci series requires at least 2 terms.")
                    }
        }
        2->{
            println(" Enter The first value :  ")
            var  first = readln().toInt()

            println(" Enter The second value :  ")
            var  second  = readln().toInt()

            var num = 0

            if ( first>second){

                 num = first
            }
            else{

               num = second
            }

            for (i in 1..num){

                if (first%i ==0 && second%i ==0){

                    var gcd = i

                    println(i)
                }
            }






        }
        3->{
            for (i in 1..5) {
                print("Enter number $i: ")
                val number = readln().toInt()


                    var factorial: Long = 1

                    for (i in 1..number) {
                        factorial *= i
                    }
                    println("Factorial of $number is $factorial")
                
            }




        }
        else->{
            println("Enter The Valid Option !!!")
        }

    }


}