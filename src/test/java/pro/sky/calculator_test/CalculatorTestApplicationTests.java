package pro.sky.calculator_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CalculatorTestApplicationTests {

    private final CalculatorServiseImp calculatorServiseImp = new CalculatorServiseImp();


    @Test
    void checkSumResultTwoNumberForPlusOperation() {
        assertEquals(10, calculatorServiseImp.sumTwoNumber(5, 5));
    }
    @Test
    void checkSumResultTwoNumberForMinusOperation() {
        assertEquals(10, calculatorServiseImp.substructTwoNumber(20, 10));
    }
    @Test
    void checkSumResultTwoNumberForMultiplicationOperation() {
        assertEquals(25, calculatorServiseImp.multiplicationTwoNumber(5, 5));
    }
    @Test
    void checkSumResultTwoNumberForDivisionOperation() {
        assertEquals(4, calculatorServiseImp.divisionTwoNumber(12, 3));
    }

    @Test
    void checkWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculatorServiseImp.divisionTwoNumber(5,0) );
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTest1")
    void shouldSumResultTwoNumberForPlusOperation(int num1, int num2) {
        assertEquals(10 , calculatorServiseImp.sumTwoNumber(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("providedParamsForTest3")
    void shouldSumResultTwoNumberForMinusOperation(int num1, int num2) {
        assertEquals(10, calculatorServiseImp.substructTwoNumber(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("providedParamsForTest1")
    void shouldSumResultTwoNumberForMultiplicationOperation(int num1, int num2) {
        assertEquals(25, calculatorServiseImp.multiplicationTwoNumber(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("providedParamsForTest2")
    void shouldSumResultTwoNumberForDivisionOperation(int num1, int num2) {
        assertEquals(5, calculatorServiseImp.divisionTwoNumber(num1, num2));
    }



    public static Stream<Arguments> providedParamsForTest1() {
        return Stream.of(

                Arguments.of(5,5)

        );
    }

    public static Stream<Arguments> providedParamsForTest2() {
        return Stream.of(

                Arguments.of(25,5)
        );
    }

    public static Stream<Arguments> providedParamsForTest3() {
        return Stream.of(

                Arguments.of(20,10)
        );
    }

}
