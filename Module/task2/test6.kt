fun main()

// tables of enter value
{
    print("Enter The value : ")
    val a = readln().toInt()
    var i = 1
    for (i in 1..10)
    {
         val b = a*i
        println("$a * $i = $b")
    }
}