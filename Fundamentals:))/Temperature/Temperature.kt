fun main ()
{

    println("Select any one operation to perform: \n \n")

    println("-------------------------------------------------------------------------------------------------------------------------------------------")


    println("1 Convert temperature fahrenheit to celsius \n" +
            "2 Convert days into months \n" +
            "3 Convert years into days and months \n" +
            "4 Convert minutes into seconds and hours \n" +
            "5 Convert kilometers into meters")
 var a = readln().toInt()

    when(a){


        1->{
            println(" Enter the value of fahrenheit: ")
            var fh = readln().toFloat()

            var calciuse = (fh- 32) * 5 / 9
            println("Temperature in Celsius (°C): $calciuse")

        }
        2->{

            println(" Enter the days count : ")

            var days = readln().toInt()

            var month = days/30.5

            println(" Your Entered $days days is approximately $month months.")

        }
        3->{

            println(" Enter the count Of Years: ")
            var years = readln().toInt()

            var days = 365
            var month = 12

            var day = years*365
            var months = 12*years


            println("$years years has $months months And $day Days ")

        }
        4->{
            print("Enter the number of minutes: ")
             var minit = readln().toFloat()

            var second = 60*minit
            var hours = minit/60


            println(" Your Entered $minit minutes has $second seconds And  $hours hours ")

        }
        5->{
            println(" Enter the lenth of kilometer: ")
            var km = readln().toFloat()

            var meters = km *1000


            println("$km kilometers is equal to $meters meters.")

        }

        else->{
            println("Enter Valid Option !!!")
        }
    }


}
