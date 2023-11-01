fun main()
{
    println("Enter the 1 name of employee: ")
    var name = readln().toString()
    println("Enter the Salary of employee : ")
    var salary1 = readln().toFloat()

    println("Enter the 2 name of employee: ")
    var name2 = readln().toString()
    println("Enter the Salary of employee : ")
    var salary2 = readln().toFloat()

    println("Enter the 3 name of employee: ")
    var name3 = readln().toString()
    println("Enter the Salary of employee : ")
    var salary3 = readln().toFloat()


    println("Enter the 4 name of employee: ")
    var name4 = readln().toString()
    println("Enter the Salary of employee : ")
    var salary4 = readln().toFloat()

    println("Enter the 5 name of employee: ")
    var name5 = readln().toString()
    println("Enter the Salary of employee : ")
    var salary5 = readln().toFloat()



    var total = salary1+salary2+salary3+salary4+salary5

    var average = total/5


println("Total salary of all employee is : $total \n Average salary is : $average")
}
