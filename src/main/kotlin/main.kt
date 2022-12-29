import java.util.Scanner

//Используя when, напишите функцию agoToText (скорее всего, вам понадобится не одна функция), которая учитывает, сколько времени прошло с последнего визита пользователя, и выдаёт текст (String).
//
//Нас будет интересовать вся фраза, например, был(а) только что или был(а) в сети 3 часа назад.
//Какие правила стоит учесть
//
//Если количество секунд от 0 до 60, используйте вариант с только что.
//Если количество секунд от 61 до 60 * 60 (один час), вариант с x минут назад.
//Если количество секунд от 60 * 60 + 1 до 24 * 60 * 60 (сутки), вариант с x часов назад.
//Если количество секунд от суток до двух, вариант вчера.
//Если количество секунд от двух суток до трёх, вариант позавчера.
//Если количество секунд больше трёх суток, вариант давно.
//
//Вам понадобятся вспомогательные функции, которые умеют делать:
//
//1 минуту назад,
//2 минуты назад,
//5 минут назад,
//11 минут назад,
//21 минуту назад,
//25 минут назад.
//
//То же самое с часами: час, часа, часов.



fun main() {
    fun secToMin(seconds: Int) : String {
        val min = seconds / 60
        return when {
            min.toString().endsWith("11") -> "$min минут назад"
            min.toString().endsWith("1") -> "$min минуту назад"
            min.toString().endsWith("12") -> "$min минут назад"
            min.toString().endsWith("13") -> "$min минут назад"
            min.toString().endsWith("14") -> "$min минут назад"
            min.toString().endsWith("2") -> "$min минуты назад"
            min.toString().endsWith("3") -> "$min минуты назад"
            min.toString().endsWith("4") -> "$min минуты назад"
            else -> "$min минут назад"
        }
    }

    fun secToHours(seconds: Int) : String {
        val hour = seconds /3600
        return when {
            hour.toString().endsWith("11") -> "$hour часов назад"
            hour.toString().endsWith("12") -> "$hour часов назад"
            hour.toString().endsWith("13") -> "$hour часов назад"
            hour.toString().endsWith("14") -> "$hour часов назад"
            hour.toString().endsWith("1") -> "$hour час назад"
            hour.toString().endsWith("2") -> "$hour часа назад"
            hour.toString().endsWith("3") -> "$hour часа назад"
            hour.toString().endsWith("4") -> "$hour часа назад"
            else -> "$hour часов назад"
        }
    }

    fun agoToText(seconds: Int): String = when {
        (seconds in 1..60) -> "только что"
        (seconds in 61..60*60) -> secToMin(seconds)
        (seconds in 60 * 60 + 1..24 * 60 * 60) -> secToHours(seconds)
        (seconds in 24 * 60 * 60 + 1..2 * 24 * 60 * 60) -> "вчера"
        (seconds in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60) -> "позавчера"
        else -> "давно"
    }
    val scan = Scanner(System.`in`)
    while (true) {
        println("Введите количество секунд:")
        val seonds = scan.nextInt()
        println("Был(а) в сети " + agoToText(seonds))
    }
}