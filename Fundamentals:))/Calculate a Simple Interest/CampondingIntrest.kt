import java.security.Principal
import kotlin.math.pow

fun main(){

    println("Enter The priciple Amount: ")
    var Principal = readln().toInt()

    println("Enter The Rate of intrest: ")

    var Rate = readln().toFloat()
    println("Enter The Tiem PEriod oF Amount In year: ")
    var time = readln().toInt()
    println(" Enter The number of times that interest is compounded per year")
    var number = readln().toInt()

    var  Compound = Principal*(1+Rate/number).pow(number*time)

    var intrest = Compound - Principal

    println("Your Compounded Intrest is : $intrest")

}