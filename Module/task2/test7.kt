// reverce order number
fun main()
{
    println("Enter the Value : ")
    var a = readln().toInt()
    var b = 0
    println(" your entered value is : $a")
    while ( a != 0)
    {
        val c =  a % 10
         b = b * 10 + c
         a = a/10
    }
    println(" the reverse order is = $b ")
}