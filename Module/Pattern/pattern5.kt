
// left side  piramid loop
fun main ()
{
    var i = 1
     var rows = 5

    for (i in 1..rows )
    {
        for( j in 1 ..i)
        {
            print("  ")
        }
        for (j in i..rows)
        {
            print(" $j")
        }

        println(" ")
    }

}

