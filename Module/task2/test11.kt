
// Addition , multiplication , division , substraction
fun main()
{
    println(" Enter the number 1 for sum or substaraction :  \n Enter the number 2 for multification or division :" )
    var a = readln().toInt()
    when (a)
    {
        1->
        {
            println(" select the  1 Addition  for Subtraction ")
            var b = readln().toInt()
            if (b==1)
            {
                println("enter the first value : ")
                var s = readln().toInt()
                println("Enter second digit : ")
                var s1 = readln().toInt()
                println(" Now select the Process :\npress 1 for addition \npress 2 for substraction ")
                var s2 = readln().toInt()
                if (s2==1)
                {
                   var s4=s+s1
                    println(" Addtion is : $s4")
                }
                else if ( s2==2)
                {
                    var s4 = s-s1
                    println("Substraction is : $s4 ")
                }

            }
        }
        2-> {
            println(" Enter 1 for multiplication and  division ")
            var m = readln().toInt()
            if (m == 1) {
                println("enter the first value : ")
                var s = readln().toInt()
                println("Enter second digit : ")
                var s1 = readln().toInt()
                println(" Now select the Process :\nPress 1 for Multiplication  \nPress 2 for Division ")
                var s2 = readln().toInt()
                if (s2 == 1) {
                    var d1 = s * s1
                    println(" multiplicayion is : $d1")
                } else if (s2 == 2) {
                    var d1 = s / s1
                    println( "Division is : $d1 ")

                }

            }

        }
    }
}