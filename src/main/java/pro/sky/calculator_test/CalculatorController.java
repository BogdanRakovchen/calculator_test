package pro.sky.calculator_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(path = "/calculator")

public class CalculatorController {
    private final CalculatorServiseImp calculatorServiseImp;

    public CalculatorController(CalculatorServiseImp calculatorServiseImp) {
        this.calculatorServiseImp = calculatorServiseImp;
    }



    public String greeting() {
        return calculatorServiseImp.greeting();
    }


    @GetMapping(path = "/plus")

    public String sumTwoNumber(
            @RequestParam(value = "num1") int number1,
            @RequestParam(value = "num2") int number2) {

        int sum;
        sum = calculatorServiseImp.sumTwoNumber(number1, number2);
        return  number1 + " + " + number2 + " " + " = " + sum;

    }

    @GetMapping(path = "/minus")
    public String substructTwoNumber(
            @RequestParam("num1") int number1,
            @RequestParam("num2") int number2) {

        int sum;
        sum = calculatorServiseImp.substructTwoNumber(number1, number2);
        return  number1 + " - " + number2 + " " + " = " + sum;
    }

    @GetMapping(path = "/multiply")
    public String multiplicationTwoNumber(
            @RequestParam("num1") int number1,
            @RequestParam("num2") int number2) {

        int sum;
        sum = calculatorServiseImp.multiplicationTwoNumber(number1, number2);
        return  number1 + " * " + number2 + " " + " = " + sum;
    }

    @GetMapping(path = "/divide")
    public String divisionTwoNumber(
            @RequestParam(value = "num1") int number1,
            @RequestParam(value = "num2") int number2) {

        int sum;
        sum = calculatorServiseImp.divisionTwoNumber(number1, number2);
        return number1 + " / " + number2 + " " + " = " + sum;

    }

}
