import java.io.File

class Main {

    // Реализовать функцию с телом выражение max(X,Y,Z), находящую максимальное из чисел X, Y и Z.
    fun max(x: Int, y: Int, z: Int): Int = if (x > y) if (x > z) x else z else if (y > z) y else z

    // Реализовать функцию fact(N), с помощью рекурсии вверх, рекурсии вниз.
    fun factup(n: Int): Int = if (n <= 1) 1 else factup(n - 1) * n

    tailrec fun factd(n: Int, a: Int): Int = if (n <= 1) n * a else factd(n - 1, n * a)
    fun factdown(n: Int): Int = factd(n, 1)

    // Найти сумму цифр числа с помощью рекурсии вверх/вниз.
    fun sumc(n: Int): Int = if (n <= 10) n else (n % 10) + (sumc(n / 10))

    fun sumcda(n: Int, a: Int): Int = if (n < 10) n + a else sumcda(n / 10, a + (n % 10))
    fun sumcd(n: Int): Int = sumcda(n, 0)

    // Написать функцию, которая принимает один аргумент и возвращает функцию.
// Аргумент, тип логический, если он ИСТИНА, возвращаем функцию, считающую сумму цифр числа, если он ЛОЖЬ, возвращаем функцию, считающую факториал числа.
// Проверить эту функцию на нескольких примерах.
    fun calculate(f: Boolean): (Int) -> Int = if (f) ::sumc else ::factup

// Написать функцию обход числа, которая выполняет операции на цифрами числа, принимает три аргумента, число, функция (например, сумма, произведение, минимум,
// максимум) и инициализирующее значение. Функция должна иметь два Int аргумента и возвращать Int. Протестировать эту функцию на операциях сумма, произведение,
// минимум, максимум цифр числа. Для тестирования и передачи аргумента использовать лямбда выражения. Инициализирующее заполнение должно иметь значение по умолчанию.

    tailrec fun digits(n: Int, a: Int = 0, f: (Int, Int) -> Int): Int =
        if (n == 0) a else digits(n / 10, f(a, n % 10), f)

    fun sumd(n: Int): Int = digits(n, 0) { a, b -> (a + b) }
    fun muld(n: Int): Int = digits(n, 1) { a, b -> (a * b) }
    fun maxd(n: Int): Int = digits(n / 10, n % 10) { a, b -> if (a > b) a else b }
    fun mind(n: Int): Int = digits(n / 10, n % 10) { a, b -> if (a < b) a else b }





// Задание 2 Вариант № 4

//    Построить 3 чистые функции, решающих следующие 3 задачи с помощью циклов. Протестировать работу этих функций.

    //    Найти произведение цифр числа.
    fun product(n:Int):Int {
        var product = 1
        var num = n
        while (num != 0){
            product *= num % 10
            num /= 10
        }
        return product
    }

    //    Найти максимальную цифры числа, не делящуюся на 3
    fun maxDig(n: Int): Int {
        var max = -1
        var num = n
        while (num != 0) {
            val digit = num % 10
            if (digit > max && digit % 3 != 0) {
                max = digit
            }
            num /= 10
        }
        return max
    }

    //    Найти количество делителей числа
    fun countDivisors(n: Int): Int {
        var count = 0
        for (i in 1..n) {
            if (n % i == 0) {
                count++
            }
        }
        return count
    }





// Задание 3

    // Найти произведение цифр числа.
    // Вверх
    fun productup(n:Int):Int = if (n <= 10) n else (n % 10) * productup(n / 10)

    // Вниз
    fun productdown(n:Int):Int = productd(n, 1)
    tailrec fun productd(n:Int, a:Int):Int = if (n <= 10) n * a else productd(n / 10, (n % 10) * a)

    // Найти максимальную цифры числа, не делящуюся на 3
    // Вверх
    fun maxDigup(n:Int):Int = if ((n < 10) && (n % 3 == 0)) -1 else if ((n % 10) % 3 == 0) maxDigup(n / 10) else maxOf(n % 10, maxDig(n / 10))

    // Вниз
    fun maxDigdown(n:Int):Int = maxDigd(n, -1)
    tailrec fun maxDigd(n: Int, max:Int):Int = if ((n < 10) && (n % 3 == 0)) max else if ((n % 10) % 3 == 0) maxDigup(n / 10) else maxOf(n % 10, maxDig(n / 10))

    // Найти количество делителей числа
    // Вверх
    fun countDivisorsup(n:Int):Int = countDivisorsu(n, 1)
    fun countDivisorsu(n:Int, a:Int):Int = if (a > n) 0 else (if (n % a == 0) 1 else 0) + countDivisorsu(n, a + 1)

    // Вниз
    fun countDivisorsdown(n: Int): Int = countDivisorsd(n, 1, 0)
    tailrec fun countDivisorsd(n: Int, a: Int, count: Int): Int = if (a > n) count else countDivisorsd(n, a + 1, if (n % a == 0) count + 1 else count)





    // Задание 4
    //Функция высшего порядка
    fun hOrderFunc(a:Int, f:(Int) -> Int):Int = f(a)



// Задание 5 Тесты



// Задание 6

    fun getFunctionByName(functionName: String): ((Int) -> Int)? {
        val functions = mapOf(
            "product" to ::product,
            "maxDig" to ::maxDig,
            "countDivisors" to ::countDivisors,
            "productup" to ::productup,
            "maxDigup" to ::maxDigup,
            "countDivisorsup" to ::countDivisorsup,
            "productdown" to ::productdown,
            "maxDigdown" to ::maxDigdown,
            "countDivisorsdown" to ::countDivisorsdown
        )
        return functions[functionName]
    }

    fun processFile(filePath: String) {
        val inputFile = File(filePath)
        val outputFile = File("output.txt")
        if (!inputFile.exists()) {
            println("Файл $filePath не найден.")
            return
        }
        val lines = inputFile.readLines()
        val results = mutableListOf<String>()
        for (line in lines) {
            val parts = line.split(" ")
            if (parts.size != 2) {
                results.add("Ошибка структуры строки: $line")
                continue
            }
            val number = parts[0].toInt()
            val functionName = parts[1]
            val function = getFunctionByName(functionName)
            if (function != null) {
                val result = function(number)
                results.add("$number $functionName $result")
            } else {
                results.add("Функция $functionName не найдена")
            }
        }
        outputFile.writeText(results.joinToString("\n"))
        println("Результаты сохранены в файл $outputFile")
    }

// Задание 7 Вариант 4
// Выделить и вызывать функции высших порядков с соответствующими аргументами.
// Включить функции, решающие предложенные задачи в программу из задания 5.
// Построить тесты указанных функций.

    //НОД 2 чисел рекурсией вверх
    fun nod(a:Int, b:Int):Int = if(b == 0) a else nod(b,a % b)

    // Найти количество четных чисел, не взаимно простых с данным
    fun countOfEvenNumber(n: Int):Int {
        var count = 0
        for (i in 2 until n step 2) {
            if (nod(n, i) != 1) {
                count++
            }
        }
        return count
    }

    // Выделим функцию высшего порядка
    fun isNonCoprime(n: Int): (Int) -> Boolean {
        return { x -> nod(n, x) != 1 }
    }

    fun countOfEvenNumbers(n: Int): Int {
        val evenNumbers = (2..n step 2).filter(isNonCoprime(n))
        return evenNumbers.size
    }

// Найти произведение максимального числа, не взаимно простого с данным, не
// делящегося на наименьший делитель исходно числа, и суммы цифр числа, меньших 5

    // Наименьший делитель исходно числа
    fun smallestDivisor(n: Int): Int {
        if (n < 2) return n
        for (i in 2..n) {
            if (n % i == 0) {
                return i
            }
        }
        return n
    }

    // Макс. число, не взаимно простое с данным, делящееся на наименьший делитель исходно числа
    fun maxNonCoprimeNotDivisibleBySmallestDivisor(n: Int): Int {
        val nonCoprimeNumbers = (2 until n).filter(isNonCoprime(n))
        val smallestDivisor = smallestDivisor(n)
        val filteredNumbers = nonCoprimeNumbers.filter { it % smallestDivisor != 0 }
        return filteredNumbers.maxOrNull() ?: 0
    }

    // Сумма цифр числа, меньших 5
    fun sumOfDigitsLessThanFive(n: Int): Int {
        return n.toString().map { it.toString().toInt() }.filter { it < 5 }.sum()
    }

    // Произведение
    fun ProductMaxSum(n:Int):Int = maxNonCoprimeNotDivisibleBySmallestDivisor(n) * sumOfDigitsLessThanFive(n)

// Задание 8 Вариант 4
//    Эйлер выяснил, что многочлен n2+n+41 порождает простые числа для всех n=0..39. Среди
//    произвольных многочленов с целыми коэффициентами n2+an+b, где коэффициенты по
//    модулю меньше 1000 найти такой многочлен, который будет порождать максимальное
//    количество простых чисел, начиная с n=0. Вывести произведение его коэффициентов.
//    Задача должна быть решена без использования списков.

    fun findMaxPrimePolynomial(): Pair<Int, Int> {
        var maxPrimes = 0
        var result = 0
        var A = 0
        var B = 0

        for (a in -999..999) {
            for (b in -999..999) {
                var n = 0
                while (isPrime(n * n + a * n + b)) {
                    n++
                }
                if (n > maxPrimes) {
                    maxPrimes = n
                    A = a
                    B = b
                }
            }
        }
        return Pair(A, B)
    }

    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n <= 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false

        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false
            }
            i += 6
        }

        return true
    }

    fun main() {
//
        println("-Задание 1")
        println("Максимальное число (1,3,2): ${max(1, 3, 2)}")
        println("Факториал 3, рек.вверх: ${factup(3)}")
        println("Факториал 3, рек.вниз: ${factdown(3)}")
        println("Сумма цифр 1234 рек.вверх: ${sumc(1234)}")
        println("Сумма цифр 1234 рек.вниз: ${sumcd(1234)}")
        println("Если T -> sumc(11): ${calculate(true)(11)}")
        println("Если F -> factup(11): ${calculate(false)(11)}")
        println("Сумма цифр (234): ${sumd(234)}")
        println("Произведение цифр (234): ${muld(234)}")
        println("Макс цифра (234): ${maxd(234)}")
        println("Мин цифра (234): ${mind(234)}\n")

        println("-Задание 2")
        println("Произведение (1223): ${product(1223)}\n")
        println("Макс не делится на 3 (4563): ${maxDig(4563)}\n")
        println("Кол-во делителей (12): ${countDivisors(12)}\n\n")

        println("-Задание 3")
        println("Произведение рек. вверх (1223): ${productup(1223)}\n")
        println("Произведение рек. вниз (1223): ${productdown(1223)}\n")
        println("Макс не делится на 3 рек. вверх (463): ${maxDigup(463)}\n")
        println("Макс не делится на 3 рек. вниз (463): ${maxDigdown(463)}\n")
        println("Кол-во делителей рек. вверх (12): ${countDivisorsup(12)}\n")
        println("Кол-во делителей рек. вниз (12): ${countDivisorsdown(12)}\n\n")

        println("-Задание 4")
        println("Произведение рек. вверх (1223): ${hOrderFunc(1223,::productup)}\n")
        println("Произведение рек. вниз (1223): ${hOrderFunc(1223,::productdown)}\n")
        println("Макс не делится на 3 рек. вверх (463): ${hOrderFunc(463,::maxDigup)}\n")
        println("Макс не делится на 3 рек. вниз (463): ${hOrderFunc(463,::maxDigdown)}\n")
        println("Кол-во делителей рек. вверх (12): ${hOrderFunc(12,::countDivisorsup)}\n")
        println("Кол-во делителей рек. вниз (12): ${hOrderFunc(12,::countDivisorsdown)}\n\n")

        println("-Задание 6")
        println("Введите путь к файлу: ")
        val scanner = Scanner(`in`)
        val filePath = scanner.nextLine()
        processFile(filePath)

        println("\n-Задание 7")

        println("Кол-во четных чисел, не взаимно простых с 6: ${countOfEvenNumbers(6)}")
        println("Вызов функции высшего порядка: ${countOfEvenNumbers(6)}")

        println("Произведение (132): ${ProductMaxSum(132)}")
        println("Макс. число, не взаимно простое с данным, делящееся на наименьший делитель исходно числа:  ${maxNonCoprimeNotDivisibleBySmallestDivisor(132)}")
        println("Сумма цифр числа, меньших 5:  ${sumOfDigitsLessThanFive(132)}\n")

        println("-Задание 8")
        val (a, b) = findMaxPrimePolynomial()
        println("A = $a, B = $b, Произведение = ${a * b}")
    }
}

fun main() = Main().main()
