// max number in input

fun main()

{
    var b = 0
    var c = 0

    println(" enter The  number : ")
    var a =  readln().toInt()

   while (a>0)
    {
         b = a % 10
        if(b>c)
        {
            c=b
        }
        a /= 10
    }
    println(" max number is  $c")
}