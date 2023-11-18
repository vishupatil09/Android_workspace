package patters

fun main(){

// number pattern triangle
    for( i in 1..5){


        for (j in 1..i){

            print(" $j")
        }
        println()
    }

    println("---------------------------------")

    // reverce triengle number pattern

    for( i in 5 downTo 1){


        for (j in 1..i){

            print(" $j")
        }
        println()
    }



    println("---------------------------------")

    // Reverce number Printing

    for( i in 1..5){


        for (j in i downTo 1){

            print(" $j")
        }
        println()
    }

    println("---------------------------------")

    //alpfhabet printing pattern

    var alpha = 'a'

    for( i in 1..5){


        for (j in 1..i){

            print(" ${(alpha.toInt()+j-1).toChar()}")


        }
        println()
    }
    println("---------------------------------")

// increment triangle number

    var num = 1

    for (i in 1..5)
    {
        for (j in 1..i){

            print(" $num ")
            num++
        }
        println()
    }
    println("---------------------------------")

    // Binary 0 1 triangle

    for (i in 1..5)
    {
        for (j in 1..i)
        {

            if (j%2 == 0)
            {
                print("0")
            }
            else{
                print("1")
            }
        }
        println()
    }

    println("-----------------------------------------------")


        //Pascal Triangle Using a Number
    val rows = 5
    var colum = 1

    for (i in 0..rows - 1) {

        for (j in 0..i) {
            if (j == 0 || i == 0)

                colum = 1


            else
                colum = colum * (i - j + 1) / j

            print("$colum")


        }

        println()
    }

}