package patters

fun main(){
    var n = 5
    for (q in 1..n)
    {

        for ( w in 1..q)
        {
            print("*")

        }
        println()
    }

    println("---------------------------------")


    for ( i in 1..n){


        for ( j in 1..n-i){

            print(" ")
        }
        for (k in 1..i)
        {
            print("*")
        }
        println()
    }
}