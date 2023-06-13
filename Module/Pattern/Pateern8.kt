
fun main ()
{
    var i = 1
    var rows = 11

    for (i in rows downTo i )
    {
        for( j in 1 ..i)
        {
            print(" *")
        }
        for ( j in i..rows)
        {
            print("  ")
        }
        for (j in rows downTo i){
            print("  ")
        }
        for ( j in 1 ..i)
        {
            print("* ")
        }
        println(" ")
    }

}
