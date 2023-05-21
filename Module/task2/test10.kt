
        // week names print by when statement
fun main()
{
    println(" Enter the number 1 for week info. : ")
    var a = readln().toInt()

    when (a)
    {
        1->
        {
            println(" select the starting day 1 for Sunday \n select 2 for Starting day Monday\n 3 for show all option press 3 ")
             var b = readln().toInt()
            if (b==1)
            {

                    println(" Sunday \n Monday \n Tuesday \n Wednesday \n Thursday \n Friday \n Saturday ")


            }
            else if  (b==2)
            {
                println(" Monday \n Tuesday \n Wednesday \n Thursday \n Friday \n Saturday \n Sunday ")

            }
            else if ( b==3)
            {


                    println(" Sunday \n Monday \n Tuesday \n Wednesday \n Thursday \n Friday \n Saturday ")
                    println("---------------------------------------------------------------------------------------")
                    println(" Monday \n Tuesday \n Wednesday \n Thursday \n Friday \n Saturday \n Sunday ")



            }

        }
    }
}