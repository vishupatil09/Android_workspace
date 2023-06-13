import java.io.DataInputStream
import java.io.FileWriter

fun main ()
{
    var dis: DataInputStream = DataInputStream(System.`in`)
    var fw: FileWriter = FileWriter("D://file1.txt")
    var ch: Char
    println(" Enter String ($ to end) : ")

        ch = dis.read().toChar()

        fw.write(ch.toInt())


    Thread.sleep(1000)
    println("success");
    fw.close()


}