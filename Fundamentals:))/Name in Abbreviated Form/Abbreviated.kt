

fun main() {

    println("What You want to perform. \n 1. SchoolName \n 2.Country Name")
    var a = readln().toInt()

    when(a){

        1->
        {
            // Convert school’s name in abbreviated form

            print("Enter the school's name: ")
            var schoolName = readLine().toString()
            var words = schoolName.split(" ")
            var shortform = words.joinToString("") { it.first().toUpperCase().toString()}
            println("Your short form for '$schoolName' is: $shortform " )


        }

        2->{
            //Convert country’s name in abbreviate form

            println(" Enter Country Name :  ")
            var Countryname = readln().toString()
            var word = Countryname.split("")
            var short = word.joinToString("").take(3).toUpperCase()
            println("Your $Countryname Short Form is : $short " )
        }

    }

}

