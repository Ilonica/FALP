import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

// Задание 1 -------------------------------------------

    @Test
    fun max() {
        val main = Main()
        val expected = 10
        assertEquals(expected, main.max(3,10,5))
    }

    @Test
    fun factup() {
        val main = Main()
        val expected = 120
        assertEquals(expected, main.factup(5))
    }

    @Test
    fun factdown() {
        val main = Main()
        val expected = 720
        assertEquals(expected, main.factdown(6))
    }

    @Test
    fun calculate() {
        val main = Main()
        val expectedSum = 10
        assertEquals(expectedSum, main.calculate(true)(1234))
        val expectedFact = 6
        assertEquals(expectedFact, main.calculate(false)(3))
    }

    @Test
    fun sumc() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.sumc(111))
    }

    @Test
    fun sumcd() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.sumcd(111))
    }

    @Test
    fun sumd() {
        val main = Main()
        val expected = 15
        assertEquals(expected, main.sumd(12345))
    }

    @Test
    fun muld() {
        val main = Main()
        val expected = 126
        assertEquals(expected, main.muld(367))
    }

    @Test
    fun maxd() {
        val main = Main()
        val expected = 7
        assertEquals(expected, main.maxd(123745))
    }

    @Test
    fun mind() {
        val main = Main()
        val expected = 2
        assertEquals(expected, main.mind(923745))
    }

// Задание 2 -------------------------------------------

    @Test
    fun product() {
        val main = Main()
        val expected = 30
        assertEquals(expected, main.product(3512))
    }

    @Test
    fun maxDig() {
        val main = Main()
        val expected = 5
        assertEquals(expected, main.maxDig(35612))
    }

    @Test
    fun countDivisors() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.countDivisors(12))
    }

// Задание 5 -------------------------------------------

    @Test
    fun productup() {
        val main = Main()
        val expected = 30
        assertEquals(expected, main.product(3512))
    }

    @Test
    fun productdown() {
        val main = Main()
        val expected = 30
        assertEquals(expected, main.product(3512))
    }

    @Test
    fun maxDigup() {
        val main = Main()
        val expected = 5
        assertEquals(expected, main.maxDig(35612))
    }

    @Test
    fun maxDigdown() {
        val main = Main()
        val expected = 5
        assertEquals(expected, main.maxDig(35612))
    }

    @Test
    fun countDivisorsup() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.countDivisors(12))
    }

    @Test
    fun countDivisorsdown() {
        val main = Main()
        val expected = 6
        assertEquals(expected, main.countDivisors(12))
    }

// Задание 7 -------------------------------------------

    @Test
    fun nod() {
        val main = Main()
        val expected = 2
        assertEquals(expected, main.nod(6, 2))
    }

    @Test
    fun countOfEvenNumber() {
        val main = Main()
        val expected = 2
        assertEquals(expected, main.countOfEvenNumber(6))
    }

    @Test
    fun countOfEvenNumbers() {
        val main = Main()
        val expected = 3
        assertEquals(expected, main.countOfEvenNumbers(6))
    }

    @Test
    fun ProductMaxSum() {
        val main = Main()
        val expected = 92
        assertEquals(expected, main.ProductMaxSum(46))
    }

}
