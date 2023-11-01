fun main(){

    println("Enter Your Sallery: ")

    var salary= readln().toFloat()

    if (salary !=null){
         println("Enter insurance rate in persantage :  %")
        var primium = readln().toInt()

        var primiumAmount = (salary*primium)/100

        println("Your Premium is : $primiumAmount")
    }

}

