package patters

fun main() {
    val n = 5 // Adjust this value to change the number of rows



    for (q in n downTo 1)
    {

        for (w in 1..(n-q))
        {
            print(" ")
        }
        for (e in 1..q){

            if (q%2 ==0)
            {
               // print("")
            }
            else {
                print(" *")
            }
        }
        println()
    }

    for (i in 2..n) {
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
}
