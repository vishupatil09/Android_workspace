// sum of first & last digit :))

fun main()
{
    println(" Enter The numbere : ")
    var a = readln().toInt()
     var b = a%10

    while ( a>9)
    {
        a=a/10
    }
    var c = a+b
    println(c)
}