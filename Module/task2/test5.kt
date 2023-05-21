import kotlin.time.times
//fibonaci series:)))
fun main()
{
    println("pls Enter the number : ")
    val a = readln().toLong()

    var b = 0
    var c = 1

    for ( i in 1..a)
    {
        print(" $b ")
        var sum  = b+c
         b = c
         c = sum
    }

}