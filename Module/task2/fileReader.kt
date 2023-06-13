import java.io.FileReader

fun main()
{

    var fr :FileReader=FileReader("D://file1.txt")
    var ch: Int
    println("File constent are: ")

        ch=fr.read()


        print(ch.toChar())


        fr.close()



}
