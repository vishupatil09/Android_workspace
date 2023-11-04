fun main() {

    println(" select any one \n 1.Check one number is pelindrone  \n 2. check 3 numbers is pelindrone: ")

    var a = readln().toInt()


    when (a) {


        1 -> {
            println(" enter your number : ")
            var num = readln().toInt()
            var reversedInteger = 0
            var originalInteger = num

            // reversed integer is stored in variable
            while (num != 0) {
                var remainder = num % 10
                reversedInteger = reversedInteger * 10 + remainder
                num /= 10
            }

            // palindrome if orignalInteger and reversedInteger are equal
            if (originalInteger == reversedInteger)
                println("$originalInteger is a palindrome.")
            else
                println("$originalInteger is not a palindrome.")


        }

        2 -> {
            var i = 1
            while (i <= 3) {

                println(" $i enter your number : ")
                var count = readln().toInt()
                i++

                var reversedInteger = 0
                val originalInteger = count

                while (count != 0) {
                    val remainder = count % 10
                    reversedInteger = reversedInteger * 10 + remainder
                    count /= 10
                }

                if (originalInteger == reversedInteger) {
                    println("$originalInteger is a palindrome.")
                } else {
                    println("$originalInteger is not a palindrome.")
                }
                
            }
        }
    }
}

