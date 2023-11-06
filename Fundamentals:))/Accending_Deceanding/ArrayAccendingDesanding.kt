fun main(){

    var array = intArrayOf(10,25,3,45,8,100,554,5)



    array.sort()
    println("Array in Ascending Order: ${array.joinToString(", ")}")

    array.sortDescending()

    println(" Array In Descending Order: ${array.joinToString(", ")}")

}