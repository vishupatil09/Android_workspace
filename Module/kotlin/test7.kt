fun main()
{
    println("Enter the full total subject marks :")
    val t = readln().toFloat()
    println("Enter the first subject marks obtain :")
    val a = readln().toFloat()
    println("Enter the second subject marks :")
    val b = readln().toFloat()
    println("Enter the third subject marks :")
    val c = readln().toFloat()
    println("Enter the fourth subject marks :")
    val d = readln().toFloat()
    println("Enter the fifth subject marks :")
    val e = readln().toFloat()
    var p= (100*(a+b+c+d+e))/t
    println(" your persentage is : $p")
}