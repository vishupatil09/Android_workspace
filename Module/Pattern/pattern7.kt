
fun main ()
{
    var i = 1
    var rows = 5

    for (i in rows downTo  i )
    {
        for( j in 1 ..i)
        {
            print("  ")
        }
        for ( j in rows downTo i)
        {
            print("$j ")
        }
        for (j in i..4){
            print("$j ")
        }
        println(" ")
    }

}
