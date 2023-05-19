fun main()
{
    println("Enter The principal amount :")
    val a= readln().toFloat()
    println(" Enter the intrest rate : ")
    val b = readln().toFloat()
    println(" Enter the time period iof loan in  years :  ")
    val c = readln().toFloat()
    var i = (a*b*c)/100
    println(" your simple intrest is : $i ")
}