package ru.netology

val case1 = "Maestro_Or_Mastercard"
val case2 = "Visa_Or_Mir"
val case3 = "VK_Pay"
val case4 = "Galaxy_Transfer"

fun main(){

    var case = case2
    var amount = 150_000.0
    var previousAmount = 600_000.0
    var yourComission = calcCommission(amount, previousAmount, case)

    if (yourComission >= 0.0) println("Коммиссия за перевод составляет $yourComission рублей.")
}

fun calcCommission(amount: Double, previousAmount: Double = 0.0, case: String = case3): Double {

    val cardTransferLimit = 150_000.0
    val cardMonthTransferLimit = 600_000.0
    val nativeTransferLimit = 15_000.0
    val nativeMonthTransferLimit = 40_000.0
    val case1ComissionUpperLimit = 75_000.0
    val case1Comission = 0.006
    val case1CustomAddition = 20
    val case2ComissionLowerLimit = 35.0
    val case2Comission = 0.0075

    return when (case) {
            case1 -> if (previousAmount > cardMonthTransferLimit || amount > cardTransferLimit) {
                        println("Превышен дневной или месячный лимит на перевод.")
                        -1.0
                     } else if (amount < case1ComissionUpperLimit) 0.0
                         else (amount * case1Comission + case1CustomAddition)

            case2 -> if (previousAmount > cardMonthTransferLimit || amount > cardTransferLimit) {
                        println("Превышен дневной или месячный лимит на перевод.")
                        -1.0
                     } else if (amount * case2Comission < case2ComissionLowerLimit) case2ComissionLowerLimit
                         else amount * case2Comission

            case3 -> if (previousAmount > nativeMonthTransferLimit || amount > nativeTransferLimit) {
                        println("Превышен дневной или месячный лимит на перевод.")
                        -1.0
                     } else 0.0
            else -> { println("Указан несуществующий метод оплаты."); -1.0 }
    }
}

