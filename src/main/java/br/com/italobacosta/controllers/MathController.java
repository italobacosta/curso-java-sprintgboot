package br.com.italobacosta.controllers;

import br.com.italobacosta.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    // http://localhost:8080/math/sum/10/20
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne) || isNumeric(numberTwo)) {
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }
    // http://localhost:8080/math/subtraction/10/20
    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne) || isNumeric(numberTwo)) {
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/multiplication/10/20
    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne) || isNumeric(numberTwo)) {
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/division/10/20
    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne) || isNumeric(numberTwo)) {
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/mean/10/20
    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne) || isNumeric(numberTwo)) {
            return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/squareRoot/20
    @GetMapping(value = "/squareRoot/{numberOne}")
    public Double squareRoot(
            @PathVariable("numberOne") String numberOne
            ) throws UnsupportedMathOperationException {
        if(isNumeric(numberOne)) {
            double number = convertToDouble(numberOne);
            return Math.sqrt(number);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a number value");
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return true;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
