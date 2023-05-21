
        // area of Triangle , rectangle and circle :)))
fun main()
{
    println(" Enter any number to  process . ----------------------------   ")

    println("1) The area of  Triangle || The Area Of Rectangle \n 2) The area of circle")
    var a = readln().toInt()
    when(a)
    {

        1->
        {
            println("1) The area of  Triangle\n2) The Area Of Rectangle")
           var a1 = readln().toInt()

            if (a1==1)
            {
                println("enter the base value : ")
                var b = readln().toInt()
                println("Enter hight value : ")
                var c = readln().toInt()
                 var d = (b*c)/2
                println("the are of Triangle is : $d")
            }
            else if (a1==2)
            {
                println("enter the base value : ")
                var b = readln().toInt()
                println("Enter hight value : ")
                var c = readln().toInt()
                println(" enter the lenth of Rectangle")
                var d1 = readln().toInt()
                var d2 = d1 * b * c
                println(" Area of Rectangle is : $d2")
            }
        }
        2->
        {
            println("enter the Radius  : ")
            var r = readln().toInt()

            var R = (22*(r*r))/7
            println(" Area of Circle is : $R")

        }
        3->
        {
            println("enter the first value : ")
            var b = readln().toInt()
            println("Enter second digit : ")
            var c = readln().toInt()

        }
    }



}