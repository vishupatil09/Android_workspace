fun main ()
{
    println(" select the any one opration  \n \n \n 1.multiplication table using for loop  \n 2.multiplication table using while loop \n 3.Display below pattern using for loop")
    var a = readln().toInt()


    when(a){

        1->{
            print("Enter a number to generate its multiplication table: ")
            val n = readln().toInt()

                println("Multiplication Table for $n:")
                for (i in 1..10) {
                    val result = n * i
                    println("$n x $i = $result")
                }

        }
        2->{
            print("Enter a number to generate its multiplication table: ")
            val n = readln().toInt()


                println("Multiplication Table for $n:")

                var i = 1
                while (i <= 10) {
                    val result = n * i
                    println("$n x $i = $result")
                    i++
                }



        }
        3->{
            println(" enter the starting integer :) ")

            var count = readln().toInt()

            for (i in 1..3) {
                for (j in 1..10) {
                    print("$count ")
                    count++
                }
                println()
            }


        }
        else->{
            println(" enter the valid option !!!")
        }
    }
}
