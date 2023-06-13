
fun main()
{
    val data = HashMap<String, String>()

    println("Enter your State Name : ")
    var State = readln().toString()

    println("Enter your City Name : ")
    var  City = readln().toString()

    println("Enter your Name : ")
    var Name = readln().toString()

    data["Your State is "] = State
    data["Your City is "] =  City
    data["your Name is "] = Name

    println("\n-- Your Entered Details --");
    for ((k, v) in data) {
        println("$k = $v")
    }
}