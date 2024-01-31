import java.util.Scanner
import kotlin.math.min

//zadanie 2
fun calculateCom(cardT: String, transfer: Int, transferAmount: Int): Int {
    val monthlyLimit = 600000
    val dailyLimit = 150000
    val vkPayLimit = 15000
    val vkPayMLimit = 40000

    return when (cardT)
    {
        "MasterCard", "Maestro" ->
        {
            if (transfer + transferAmount <= monthlyLimit) 0 else
                (0.006 * transferAmount + 20).toInt()
        }
        "Visa", "Мир" ->
        {
            val commission = 0.0075 * transferAmount
            if (commission < 35) 35 else
                commission.toInt()
        }
        "VK Рау" -> 0
        "VK Pay" ->
        {
            if (transferAmount > vkPayLimit || transfer + transferAmount > vkPayMLimit) {
                println("Превышены лимиты VK Pay: перевод невозможен")
                -1
            } else {
                0
            }
        }
        else -> {
            println("Неверный тип карты")
            return -1
        }

    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Введите тип карты (MasterCard, Maestro, Visa, Мир, VK Pay) ")
    val cardT = scanner.nextLine()

    print("Введите сумму предыдущих переводов ")
    val transfer = scanner.nextInt()

    print("Введите сумму перевода ")
    val transferAmount = scanner.nextInt()

    val commission = calculateCom(cardT, transfer, transferAmount)
    if (commission != -1) {
        println("Комиссия: $commission рублей")
    }
}


