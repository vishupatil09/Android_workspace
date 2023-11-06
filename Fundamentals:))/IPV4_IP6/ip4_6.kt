fun main() {
    generateIPv4Addresses()
    generateIPv6Addresses()
}

fun generateIPv4Addresses() {
    println("IPv4 Addresses:")
    for (a in 0..255) {
        for (b in 0..255) {
            for (c in 0..255) {
                for (d in 0..255) {
                    val ipAddress = "$a.$b.$c.$d"
                    println(ipAddress)
                }
            }
        }
    }
}

fun generateIPv6Addresses() {
    println("IPv6 Addresses:")
    for (i in 1..65535) {
        val ipAddress = "2001:0db8:85a3:${i.toString(16).padStart(4, '0')}:0:0:0:7334"
        println(ipAddress)
    }
}
