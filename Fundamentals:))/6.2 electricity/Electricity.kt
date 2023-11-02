fun main() {
    print("Enter the electricity unit charge: ")
    val unitCharge = readln().toFloat()

    if (unitCharge != null) {
        val totalBill = when {
            unitCharge <= 50 -> unitCharge * 0.50
            unitCharge <= 150 -> 50 * 0.50 + (unitCharge - 50) * 0.75
            unitCharge <= 250 -> 50 * 0.50 + 100 * 0.75 + (unitCharge - 150) * 1.20
            else -> 50 * 0.50 + 100 * 0.75 + 100 * 1.20 + (unitCharge - 250) * 1.50
        }

        val surcharge = totalBill * 0.20
        val finalBill = totalBill + surcharge

        println("Electricity Unit Charge: $unitCharge")
        println("Total Electricity Bill: Rs. $finalBill")
    } else {
        println("Invalid input. Please enter a valid electricity unit charge.")
    }
}
