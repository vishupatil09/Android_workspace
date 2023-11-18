package patters

fun main(){


    println(" enter the triengle size:  ")
    var n = readln().toInt()


    for (i in 1..n) {
        // Print leading spaces
        for (j in 1..(n - i)) {
            print(" ")
        }

        // Print characters
        for (j in 1..i) {
            if (i%2 ==0)
            {
                //  print("")
            }
            else {
                print(" *")
            }
        }
        // Move to the next line
        println()
    }

    for ( k in 1..n-2)
    {

        print(" ")
    }
    print("| | |")


}