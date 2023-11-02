fun  main(){

    println(" select the opration you want to perform: ")

    println("--------------------------------------------------------------------------------")

    println("1.Whether You Are Eligible for Voting or Not \n" +
            "2. To check whether a character is in the alphabet or not.\n" +
            "3. To input any alphabet and check whether it is a vowel or consonant.")

    var a = readln().toInt()


    when(a)
    {

        1->{
            println(" enter you Age to check :  ")

            var age = readln().toInt()

            if (age>=18){

                println(" Are Eligible to vote ")
            }
            else{
                println(" You are not Eligible to vote")
            }

        }
        2->{
            print("Enter a character: ")
            val Char = readLine()?.get(0)

            if (Char != null) {
                val isAlphabet = Char.isLetter()

                if (isAlphabet) {
                    println("$Char is in the alphabet.")
                } else {
                    println("$Char is not in the alphabet.")
                }
            } else {
                println("Invalid input. Please enter a character.")
            }


        }
        3->{
            print("Enter an alphabet: ")
            val alphabet = readLine()?.toLowerCase()

            if (alphabet != null && alphabet.length == 1 && alphabet[0].isLetter()) {
                val category = when (alphabet[0]) {
                    'a', 'e', 'i', 'o', 'u' -> "Vowel"
                    else -> "Consonant"
                }

                println("$alphabet is a $category.")
            } else {
                println("Invalid input. Please enter a single alphabet character.")
            }


        }
        else->{
            println(" enter the valid option")
        }
    }

}